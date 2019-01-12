ActiveMq admin
http://localhost:8161/admin/

About ActiveMQ Persistence
3 Steps
1:enter into D:\penn\dev\apache-activemq-5.13.3-bin\apache-activemq-5.13.3\conf
edit activemq.xml
like this
        <persistenceAdapter>
            <!--<kahaDB directory="${activemq.data}/kahadb"/>-->
			<jdbcPersistenceAdapter dataSource="#mysql-ds"/>
        </persistenceAdapter>
add jdbc bean
like this
        <bean id="mysql-ds" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
            <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
            <property name="url" value="jdbc:mysql://localhost:3306/activemq_db?relaxAutoCommit=true"/>
            <property name="username" value="root"/>
            <property name="password" value="root"/>
            <property name="poolPreparedStatements" value="true"/>
        </bean>
        
        
cope mysql.lib and dbcp2.lib into 
D:\penn\dev\apache-activemq-5.13.3-bin\apache-activemq-5.13.3\lib
my lib version are these:
commons-dbcp2-2.1.1.jar
mysql-connector-java-5.1.40.jar


At last
enter into D:\penn\dev\apache-activemq-5.13.3-bin\apache-activemq-5.13.3\bin\win64
run activemq.bat
and you will see 3 tables in your mysql database.
activemq_db.activemq_acks
activemq_db.activemq_lock
activemq_db.activemq_msgs

the activemq_db.activemq_msgs is the table that stored the messages.
once the message was consumered ,it would be deleted.
        

