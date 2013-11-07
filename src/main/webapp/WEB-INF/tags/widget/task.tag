<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="task" required="true" type="fr.todooz.domain.Task" %>

<div>
    <p><fmt:formatDate value="${task.date}" pattern="dd MMM yyyy"/></p>
    <span class="lead">${task.title}</span>
    <code>${task.tags}</code>
    <p>${task.text}</p>
</div>