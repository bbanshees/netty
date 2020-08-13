package com.spike.jvm.c1;

/**
 * @description: 关于栈的测试
 * @author: Spike
 * @date: 2020-06-22 16:53
 **/

public class StackStruTest {
    public static void main(String[] args) {
//        int i = 2 + 3;

        int i = 2;
        int j = 3;
        int k = i + j;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("nihao");
    }

}
//
//psql
//    yum install https://download.postgresql.org/pub/repos/yum/reporpms/EL-7-x86_64/pgdg-redhat-repo-latest.noarch.rpm
//
//    yum install -y postgresql10-server postgresql10-contrib
//
//        /usr/pgsql-10/bin/postgresql-10-setup initdb
//
//        passwd postgres  postgres/aisino12345678
//
//        systemctl start postgresql-10.service 端口5432
//
//        adduser kong
//
//        passwd kong kong/aisino12345678
//
//        su postgres
//
//        psql
//
//        创建用户：postgres=# create user kong with password 'kong';
//
//        创建数据库：postgres=# create database kong owner kong;
//
//        授权：postgres=# grant all privileges on database kong to kong;
//
//        配置完成，退出
//
//        postgres=# \q
//
//        bash-4.2$ exit
//
//        vim  /var/lib/pgsql/10/data/pg_hba.conf
//
//        将peer修改为md5(如果后面有报错，则修改为trust ip4，ip6都为trust【这个栏目的】)
//
//        vim /var/lib/pgsql/10/data/postgresql.conf
//            去掉注释，修改后如图
//            listen_addresses = '*'
//            max_connections = 100
//
//        配置文件修改后需重启服务：$ systemctl restart postgresql-10.service
//
//        psql -U kong -d kong -h 127.0.0.1 -p 5432
//
//kong
//
//        $ sudo yum update -y
//        $ sudo yum install -y wget
//        $ wget https://bintray.com/kong/kong-rpm/rpm -O bintray-kong-kong-rpm.repo
//        $ export major_version=`grep -oE '[0-9]+\.[0-9]+' /etc/redhat-release | cut -d "." -f1`
//        $ sed -i -e 's/baseurl.*/&\/centos\/'$major_version''/ bintray-kong-kong-rpm.repo
//        $ sudo mv bintray-kong-kong-rpm.repo /etc/yum.repos.d/
//        $ sudo yum update -y
//        $ sudo yum install -y kong
//
//        cp /etc/kong/kong.conf.default /etc/kong/kong.conf
//
//        vim /etc/kong/kong.conf
//            打开注释
//            pg_host = 127.0.0.1             # Host of the Postgres server.
//            pg_port = 5432                  # Port of the Postgres server.
//            pg_timeout = 5000               # Defines the timeout (in ms), for connecting,
//                                        # reading and writing.
//
//            pg_user = kong                  # Postgres user.
//            pg_password = aisino12345678    # Postgres user's password.
//            pg_database = kong
//
//
//        kong migrations bootstrap
//
//        kong start/stop
//konga(可视化界面)
//        npm install --save node-sass --registry=https://registry.npm.taobao.org --disturl=https://npm.taobao.org/dist --sass-binary-site=http://npm.taobao.org/mirrors/node-sass
