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

--changeset Petty:caas-init-ddl-2
alter table system_global_configuration
	add del_flag tinyint unsigned default 0 not null comment '删除标记 0 未删除 1 删除';

alter table system_global_configuration
	add creator varchar(128) null comment '创建人';

alter table system_global_configuration
	add create_time datetime null comment '创建时间';

alter table system_global_configuration
	add modifier varchar(128) null comment '修改人';

alter table system_global_configuration
	add modify_time datetime null comment '修改时间';

