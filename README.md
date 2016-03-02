##JSF 2 + Spring 3 integration

###There are some types of integrate saint Spring to JSF:
+ JSF XML faces-config.xml - shit
+ Spring annotations
+ JSR injection - wtf

###First of all add dependencies to pom.xml:
[pom.xml](https://github.com/UnionOne/JSFSpring/blob/master/pom.xml#L17-L26)
```xml
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>3.1.2.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>3.1.2.RELEASE</version>
        </dependency>
```

###Then add some lines to faces-config.xml:
[faces-config.xml](https://github.com/UnionOne/JSFSpring/blob/master/src/main/webapp/WEB-INF/faces-config.xml#L8-L10)
```xml
    <application>
        <el-resolver>
            org.springframework.web.jsf.el.SpringBeanFacesELResolver
        </el-resolver>
    </application>
```

###And get saint applicationContext.xml to WEB-INF folder:
[applicationContext.xml](https://github.com/UnionOne/JSFSpring/blob/master/src/main/webapp/WEB-INF/applicationContext.xml#L9)
```xml
  <context:component-scan base-package="com.itibo"/>
```

###Add listener to web.xml:
[web.xml](https://github.com/UnionOne/JSFSpring/blob/master/src/main/webapp/WEB-INF/web.xml#L10-L15)
```xml
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <listener>
        <listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
    </listener>
```

###Spring annotation:
[UserBo.java](https://github.com/UnionOne/JSFSpring/blob/master/src/main/java/com/itibo/spring/bean/bo/impl/UserBoImpl.java#L10)
```java
@Service
public class UserBoImpl implements UserBo {
    @Override
    public String getMessage() {
        return "JSF Spring Integration";
    }
}
```

[UserBean.java](https://github.com/UnionOne/JSFSpring/blob/master/src/main/java/com/itibo/spring/bean/UserBean.java#L14-L16)
```java
@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
    @Autowired
    UserBo userBo;

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    public String printMsgFromSpring() {
        return userBo.getMessage();
    }
}
```


