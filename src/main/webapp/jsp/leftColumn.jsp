<%@ page import="java.util.List" %>
<%@ page import="ru.truesik.bookstore.model.Category" %>
<%@ page import="java.util.Iterator" %>
<li>
    <div>
        <a class="link1" href="<%=param1%>?action=allBooks">
            <span style="margin-left: 15px;"
                  class="label">All Books</span>
        </a>
    </div>
</li>
<li>
    <div><span class="label" style="margin-left: 15px;">Categories</span></div>
    <ul>
        <%
            List<Category> categoryList1 = (List<Category>) application.getAttribute("categoryList");
            Iterator<Category> iterator1 = categoryList1.iterator();
            while (iterator1.hasNext()) {
                Category category1 = iterator1.next();%>
        <li>
            <a class="label"
               href="<%=param1%>?action=category&categoryId=<%=category1.getId()%>&category=<%=category1.getCategoryDescription()%>">
            <span class="label"
                  style="margin-left: 30px;">
                <%=category1.getCategoryDescription()%>
            </span>
            </a>
        </li>
        <%}%>
    </ul>
</li>
<form class="search">
    <input type="hidden" name="action" value="search"/>
    <input id="text" type="text" name="keyWord" size="12"/>
    <%--<span class="tooltip_message">?</span>--%>
    <p/>
    <input id="submit" type="submit" value="Search"/>
</form>