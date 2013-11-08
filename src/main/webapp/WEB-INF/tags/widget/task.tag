<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ attribute name="task" required="true" type="fr.todooz.domain.Task" %>

<span class="lead"><a href="/edit/${task.id}">${fn:escapeXml(task.title)}</a></span>
<div>
    <p><fmt:formatDate value="${task.date}" pattern="dd MMM yyyy"/></p>
    <span class="lead">${task.title}</span>
    <code>${task.tags}</code>
    <p>${task.text}</p>
</div>