### Raft 实现

参考书籍 [分布式一致性算法开发实战](https://book.douban.com/subject/35051108/) 

书作者的实现 [github](https://github.com/xnnyygn/xraft)

[raft 论文翻译](https://github.com/maemual/raft-zh_cn)

[raft 算法动画演示](http://thesecretlivesofdata.com/raft/)


### 选举超时
就是新一轮选举开始时，每个节点随机思考要不要做领导者的时间，这个时间一般100-到200ms，非常短。
假设集群由3个节点组成，为了防止3个节点同时发起投票，Raft会给每个节点分配一个随机的选举超时时间（Election Timeout）。在这个时间内，节点必须等待，不能成为Candidate状态。
现在假设节点a等待168ms，节点b等待210ms，节点c等待200ms。由于a的等待时间最短，所以它会最先成为Candidate，并向另外两个节点发起投票请求，希望它们能选举自己为Leader。另外两个节点收到请求后，假设将它们的投票返回给Candidate状态节点a，节点a由于得到了大多数节点的投票，就会从Candidate变为Leader


### @Nonnull,


### 单元测试
以下是具体准备的内容：
1. 测试专用定时器组件 NUllScheduler
2. 测试专用RPC组件 MockConnector
3. 暴露role的状态数据
4. 快速构造NodeImpl的 NodeBuilder


NodeImplTest.testStartFresh()