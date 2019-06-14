# 心愿便利贴-后端

## 项目出发点

![](http://img.sonicming.top/201905282130_113.png)



## 项目描述

​	本项目基于抽卡游戏模式，将孩子的心愿按照实现成本的高低，区分心愿卡的稀有程度。当孩子进行了某些家长满意的行为后，可以用抽卡的方式对孩子进行奖励，以提升孩子的行为积极性，同时促进孩子和家长之间的沟通，对孩子的行为做积极的引导，也能让家长知悉孩子的诉求。



## 其他待补充


## BE环境构筑
目前环境使用 
・postgres 
・eclipse Oxygen
------------------
1.安装postgres （本项目支持mysql）。
2.eclipse中，添加导入maven项目。（在导入前可在marketplace中安装spring tool suite)
3.在src/main/resources/application.propertise中，设置微信小程序的信息和数据库连接信息。
4.启动选择 springboot App。

※本项目使用flyway管理数据库。启动flyway报错可删除所有表单后再启动。