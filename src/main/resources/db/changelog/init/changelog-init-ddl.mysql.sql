--liquibase formatted sql

--changeset Petty:caas-init-ddl-1
create table system_global_configuration
(
	id varchar(255) not null comment '主键',
	gitlab_home_path varchar(400) null comment 'gitlab地址',
	docker_host varchar(255) default '0.0.0.0:2375' not null comment 'docker主机地址',
	workspace varchar(255) default '/usr/local/build/workspace' not null comment '源码构建存放目录',
	docker_registry_path varchar(400) default 'http://127.0.0.1' not null comment 'Docker镜像仓库地址',
	docker_registry_project varchar(255) null comment 'Docker镜像仓库项目名',
	docker_registry_username varchar(255) null,
	docker_registry_password varchar(255) null,
	maven_home varchar(255) default '/usr/local/maven' null,
	constraint system_global_configuration_pk
		primary key (id)
);

