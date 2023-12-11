<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section>
    <h1 class="pb-3">Search Customer</h1>
</section>

<section>
    <div class="container pt-5">
        <form method="get" action="/customer/search">
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" id="firstName" name="firstName" placeholder="Search by first name"
                       value="${firstName}"/>
            </div>

            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" id="lastName" name="lastName" placeholder="Search by last name" value="${lastName}"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

        <c:if test="${not empty customers}">
            <h1>Customers Found ${customers.size()}</h1>
            <table class="table table-hover">
                <tr>
                    <td>Id</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Phone</td>
                    <td>City</td>
                    <td>Image</td>
                    <td>Edit</td>
                </tr>
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.city}</td>
                        <td><img src="${customer.imageUrl}" style="max-width: 100px"/></td>
                        <td><a href="/customer/edit/${customer.id}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>