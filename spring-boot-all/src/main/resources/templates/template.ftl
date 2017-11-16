<#list users as user>
id:${user.id}<br>
name : ${user.name}<br>
age:${user.age}<br>
createTime:${user.createTime ? string('yyyy-MM-dd hh:mm:ss')}<br>
<#if user.id == "1001">
	欢迎1001号!<br>
</#if>
=========================<br>
</#list>
