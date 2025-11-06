<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="eleve.major.ejb.module2.models.AnneeScolaire" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
    <title>🏆 ÉLÈVES - MAJOR</title>
    <style>
        body {
            font-family: Arial;
            margin: 20px;
            background: #f0f8ff
        }

        .major {
            background: gold !important;
            font-weight: bold;
            color: #000 !important
        }

        table {
            border-collapse: collapse;
            width: 100%
        }

        th,
        td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left
        }

        th {
            background: #4CAF50;
            color: white
        }

        .majors-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
            margin: 20px 0;
        }

        .major-card {
            background: gold;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            flex: 1;
            min-width: 250px;
            max-width: 400px;
        }

        .select-container {
            margin: 20px 0;
            text-align: center;
        }

        select {
            padding: 8px;
            font-size: 16px;
            border-radius: 5px;
        }
    </style>
</head>
</head>
<body>
<h1>📊 CLASSEMENT ÉLÈVES</h1>
<br>
<div class="select-container">
    <form>
        <label for="annee">Choisissez une année scolaire :</label>
        <select id="annee" name="annee">
            <%
                List<AnneeScolaire> annees = (List<AnneeScolaire>) request.getAttribute("annees");
                if (annees != null) {
                    for (AnneeScolaire a : annees) {
            %>
                        <option value="<%= a.getId() %>">
                            <%= a.getAnneeDebut() %> - <%= a.getAnneeFin() %>
                        </option>
            <%
                    }
                } else {
            %>
                <option>Aucune année scolaire trouvée</option>
            <%
                }
            %>
        </select>
    </form>
</div>
</body>
</html>