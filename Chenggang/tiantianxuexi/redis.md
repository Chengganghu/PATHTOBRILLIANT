# redis 对象（数据结构）

对象的**类型**与**编码**， type and encoding

- 字符串对象

编码方式有三种：int raw embstr

如果能用long型表示，字符串对象会自动转换为int型（redis中除了long，其余全部是指针类型，类似于Java中引用数据类型）

raw就是SDS，在大于39个字节的时候会使用SDS

embstr用于存储短字符串值，小于39字节，redisObject和SDSObject使用连续的内存空间

- 列表对象

编码方式：压缩列表或者是链表

- 哈希对象

编码方式：压缩列表或者是哈希表

- 集合对象

编码方式：整数集合或者是哈希表

集合对象的哈希表实现方式中，只用字典的key存值，而字典的value置为空

- 有序集合对象

编码方式：压缩列表或者是跳表

如果使用跳表作为有序集合的编码方式，那么还会同时使用字典存储集合元素和元素得分



redis对象使用**引用计数**作为内存回收的方式

内存使用过高时，redis会自动清除对象空转时长较长的对象



# 数据库

## 过期策略

给某个键设置过期时长 **EXPIRE PEXPIRE**，在多长时间之后过期

给某个键设置过期时间点 **EXPIREAT PEXPIREAT**， 在某个时间点过期

P指毫秒

**PERSIST** 取消某个键的过期时间

过期键删除策略：

- 定时删除

通过使用定时器，保证过期的键会被及时删除，但是会损耗大量CPU，此方法不现实

- 惰性删除

只在取出键的时候进行过期判断，对cpu友好，对内存不友好

- 定期删除

每隔一段时间执行一次删除过期键的操作，并且限制删除操作的时长和频率减少删除操作对CPU的影响

redis当中是配合使用惰性删除和定期删除策略

## AOF RDB

生成RDB文件时，忽略过期键，载入RDB文件时，主服务器忽略过期键，从服务器全部载入

生成AOF文件时，会显式的追加一条DEL语句用与删除过期键，载入时会忽略过期键

- RDB

SAVE 和 BGSAVE（BackGroud SAVE）

save会阻塞redis服务器进程，BGSAVE不会阻塞redis服务器进程，bgsave会folk出一个子进程

载入RDB文件只在redis服务器重启时

RDB**自动间隔性保存**，可以设置**save**选项：

save 900 1 ：900秒内对数据库进行了至少一次修改

save 300 10: 300秒内对数据了进行了至少十次修改

save 60 10000： 60秒内对数据库进行了至少10000次修改

**dirty计数器**：记录上一次执行save命令或者BGSAVE命令后，服务器对数据库状态进行了多少次修改

**lastSave**：unix时间戳，记录服务器上一次成功执行save或者bgsave命令的时间

- AOF

aof_buf: aof缓冲区，追加的命令会先保存在aof_buf缓存区

redis服务器进程类似于一个事件循环

```
def eventLoop():
	while True:  //死循环
	processFileEvents(); // 处理文件事件，接收命令以及发送命令回复，处理命令请求时可能会有新内容追加到aof_buf
	processTimeEvents(); // 处理时间时间
	flushAppendOnlyFile(); // 将aof_buf缓存区的值写入到aof文件中
```

appendfsync选项的值来决定何时将aof_buf缓存里面的数据写入到aof文件中

| appendfsync的值 | flushAppendOnlyFile函数的行为                                |
| :-------------- | ------------------------------------------------------------ |
| always          | 将aof_buf缓冲区的所有内容写入并同步到aof文件中               |
| everysec        | 将aof_buf缓冲区的所有内容写入到aof文件，如果上次同步aof文件的时间超过一秒钟，那么再次对aof文件进行同步 |
| no              | 将aof_buf缓冲区的文件的所有内容写入到aof文件，但不对aof文件进行同步，何时同步由操作系统决定 |

默认配置是everysec











