<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">User Detail</h1>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container pt-5">
        <c:if test="${not empty customer}">
            <table class="table table-hover">
                <tr>
                    <td>Id</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Phone</td>
                    <td>City</td>
                    <td>Image</td>
                    <td>Detail</td>
                </tr>

                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.city}</td>
                    <td><img src="${customer.imageUrl}" style="max-width: 100px"/></td>
                    <td><a href="/customer/details?id=${customer.id}">Details</a></td>
                </tr>
            </table>
            <form method="get" action="/customer/edit/${customer.id}">
                <button type="submit" class="btn btn-primary">Edit</button>
            </form>
        </c:if>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>