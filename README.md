# 纯Flutter项目Android端热更新（三)

### 纯flutter项目下，利用tinker进行热更新的demo


之前做HotfixFliutter的时候，我在纯Flutter项目的android下尝试接入Tinker，
但是在编译之后，就出现了[tinkerid不一致](https://github.com/Tencent/tinker/issues/1422)，然后就没继续跟进，到现在tinker开发组也没给这个Bug回应。但是网友提了要求，让我搞下，我就硬着头皮再试试。  

#### 一 新建纯Flutter项目  
[FlutterHotFix](https://github.com/magicbaby810/FlutterHotFix)  

纯Flutter项目打开后，右侧是没有gradle task任务栏的，另起个窗口打开android目录，这样一个新的android项目窗口就出来  

#### 二 接入tinker 
移步到[HotfixFlutter](https://github.com/magicbaby810/HotfixFlutter)去把tinker的一套配置copy过来。  

把AppApplication也copy过来，MultiDexApplication换成FlutterApplication，去AndroidManifest.xml里把application标签里的name给换成AppApplication。 


#### 三 配置插件
进入 FlutterApplication，在onCreate方法里也是使用了   

```
FlutterInjector.instance().flutterLoader().startInitialization(this);
```
来初始化Flutter，那就好办了，只要在这个方法下插桩就行了，但是之前的hannibal没办法区分当前项目是否是纯Flutter，所以另起个gradle项目，把这个位置给hook处理下，上传到jitpack上  

```
classpath 'com.github.magicbaby810:hannibalx:0.1'
```
#### 四 跑流程
配置到项目中，接下来还是跑一遍tinker的操作流程，发现一个大坑，在执行bindTinkerPatchRelease的时候，在build->app->outputs->patch，这个目录生成补丁后，会很快被删除，等于我要盯着这个补丁目录，一旦生成，赶紧copy出去一份，真TMD拼手速啊。

终于在试了几次后，掌握这个文件生成补丁的规律，每次出现patch目录，延迟200ms再copy到上层目录，这样正好里面的补丁也生成了。上传补丁，等了半天也不见补丁下发，解压开补丁包，在YAPATCH.MF里发现From里的tinkerid跟我基准包里的差了3秒，这才想起，以前就遇到过这个问题，当时是差了1秒。哎，1秒还是3秒无所谓了。  

这个问题不能继续挡着我，淦。  

突然想到这个tinkerid是自动生成的，如果我配置成死的，不就不会来回变了。  
    
回到tinker-support.gradle里，把自动生成tinkerid配置注掉，按照以前手动配置tinkerid的套路操作一番，补丁下发成功，修复完成。

## 我真是个人才啊！

大家在使用的时候有什么问题，都可以来 麻花疼：1151212481 找我咨询
