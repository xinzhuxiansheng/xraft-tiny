### Raft 实现

参考书籍 [《分布式一致性算法开发实战》](https://book.douban.com/subject/35051108/) 

书作者的实现 [github](https://github.com/xnnyygn/xraft)

[raft 论文翻译](https://github.com/maemual/raft-zh_cn)

[raft 论文](https://web.stanford.edu/~ouster/cgi-bin/papers/raft-atc14)

[raft 算法动画演示](http://thesecretlivesofdata.com/raft/)

## Leader选举
在任何时刻，每个节点都处于以下3种状态之一：
1. Leader：处理所有的客户端请求（如果客户端将请求发给Follower，Follower会把请求重定向给Leader）
2. Candidate: 用于选举产生新的领导人
3. Follower: 不会发送任何请求，只会简单的响应来自Leader或Candidate的请求

### 选举超时
就是新一轮选举开始时，每个节点随机思考要不要做领导者的时间，这个时间一般150-到300ms，非常短。
假设集群由3个节点组成，为了防止3个节点同时发起投票，Raft会给每个节点分配一个随机的选举超时时间（Election Timeout）。在这个时间内，节点必须等待，不能成为Candidate状态。
现在假设节点a等待168ms，节点b等待210ms，节点c等待200ms。由于a的等待时间最短，所以它会最先成为Candidate，并向另外两个节点发起投票请求，希望它们能选举自己为Leader。另外两个节点收到请求后，假设将它们的投票返回给Candidate状态节点a，节点a由于得到了大多数节点的投票，就会从Candidate变为Leader

前提：

解决了：
1. 如何首先让某个节点变成"Candidate"？ 
因为只有 "Candidate"主动触发选举
2. 若两个节点的超时时间，相差不大，若出现第一个A节点从Follower 变成 Candidate，这时A节点会向其他节点发送选举请求，可这时 另一个B节点也达到选举超时，从Follower 变成 Candidate，这会怎么办？


### Term(任期)






### @Nonnull,


### 单元测试
以下是具体准备的内容：
1. 测试专用定时器组件 NUllScheduler
2. 测试专用RPC组件 MockConnector
3. 暴露role的状态数据
4. 快速构造NodeImpl的 NodeBuilder


NodeImplTest.testStartFresh()


## 日志复制


## 安全性
* RequestVote RPC执行了这样的限制：RPC中包含candidate日志信息，如果投票者自己的日志比candidate的还新，它会拒绝该投票请求。
* Raft通过比较两份日志中最后一条日志条目的索引值和任期号来定义谁的日志比较新
* 如果两份日志最后条目的任期号不同，那么任期号大的日志更新
* 如果两份日志最后条目的任期号相同，那么日志较长的那个更新

* 只有leader当前任期内的日志条目才通过计算副本数目的方式来提交
* 一旦当前任期的某个日志条目以这种方式被提交，那么由于日志匹配特性，之前的所有日志条目也都会被间接地提交

**时间与可用性限制**    
* raft算法整体不依赖客观时间，也就是说，哪怕因为网络或其他因素，造成后发的RPC先到，也不会影响raft的正确性
* 只要整个系统满足下面的时间要求，raft就可以选举出并维护一个稳定的leader
* 广播时间（broadcastTime） << 选举超时时间（electionTimeout）<< 平均故障时间（MTBF）
* 广播时间和平均故障时间是由系统决定的，但是选举超时时间是我们自己选择的。raft的RPC需要接受并将信息罗盘，所以广播时间大约是0.5ms到20ms，
取决于存储技术。因此，选举超时时间可能需要在10ms到500ms之间。大多数服务器的平均故障间隔时间都在几个月甚至更长。


## 集群成员变更


## Raft基本概念总结   
**共识算法的三个主要特性:**    

1. 共识算法可以保证在任何"非拜占庭情况"下的正确性
通常来说，共识算法可以解决网络延迟、网络分区、丢包、重复发送、乱序问题、无法解决拜占庭问题（如存储不可靠，消息错误）
2. 共识算法可以保证在大多数机器正常的情况下集群的高可用性，而少部分的机器缓慢不影响整个集群的性能
3. 不依赖外部时间来保证日志的一致性
这一点即是共识算法的优势，因为共识算法不受硬件影响，不会因外部因素造成错误。但也造成一些限制，让共识算法受网络影响很大，
在异地容灾场景下，共识算法的支持性比较差。

**raft区分于其他共识算法的三个特征:**     

`Strong leader`：在raft中，日志只能从leader流向其他服务器。这简化了复制日志的管理，使得raft更容易理解   
`Leader election`：raft使用随机计时器进行leader选举，这只需在任何共识算法都需要的心跳（heartbeats）上增加少量机制
，同时能够简单快速地解决冲突。     
`Membership changes`: raft使用一种共同一致（joint consensus）的方法来处理集群成员变更的问题，变更时
，两种不同的配置的大多数机器会重叠。这允许整个集群在配置变更期间可以持续正常运行。   






