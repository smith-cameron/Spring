<%@ tag language="java" pageEncoding="ISO-8859-1"%>
31 lines (31 sloc)  1.66 KB
   
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
        <div class="col col-sm-12">
            <h1 class="">Edit a Language:</h1>
            <div class="card">
                <form:form method="post" action="/languages/${language.id}" class="card-body" modelAttribute="language">
                    <input type = "hidden" name="_method" value="put">
                    <div class="row mb-3">
                        <form:label path="name" for="language_name" class="form-label">Name:</form:label>
                        <form:input path="name" type="text" class="form-control" name="language_name"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="creator" for="language_creator" class="form-label">Creator:</form:label>
                        <form:input path="creator" class="form-control" name="language_creator"/>
                        <form:errors path="creator"/>
                    </div>
                    <div class="row mb-3">
                        <form:label path="version" for="language_version" class="form-label">Version:</form:label>
                        <form:input path="version" class="form-control" name="language_version"/>
                        <form:errors path="version"/>
                    </div>
                    <div class="row justify-content-end">
                        <button type="submit" class="col-sm-3 btn btn-primary">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>