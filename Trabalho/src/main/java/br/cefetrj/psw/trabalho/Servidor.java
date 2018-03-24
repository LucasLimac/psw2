/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.trabalho;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servidor que adiciona as notas e situacao do aluno em um arraylist e imprime ele em uma tabela
 * @author Lucas Lima
 */
@WebServlet(name = "Servidor", urlPatterns = {"/Servidor"})
public class Servidor extends HttpServlet {

   ArrayList<Aluno> a = new ArrayList<>();
   
   /**
 *Metodo que recebe os dados do aluno como nota, trabalho, frequencia, projeto, nota final e imprime em uma tabela html
 * 
 */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
      
        
        
        try{
            
        
            
        String aluno = (String)req.getParameter("aluno");

        double nota1 = Double.parseDouble(req.getParameter("nota1"));  
        double trabalho = Double.parseDouble(req.getParameter("trabalho"));    
        double projeto = Double.parseDouble(req.getParameter("projeto"));    
        double notafinal = Double.parseDouble(req.getParameter("notafinal"));    
        double frequencia = Double.parseDouble(req.getParameter("frequencia")); 
        
        double m1 = (0.7 * ((nota1 + trabalho) / 2)) + (projeto * 0.3);
  
    
        
        String situacao = situacao(frequencia, nota1, trabalho, projeto, notafinal);
        
        
        
        //Aluno [] array = new Aluno[10];
           a.add(new Aluno(aluno, nota1, frequencia, trabalho, projeto, notafinal,m1, situacao));
                
            
        //Aluno n = new Aluno(aluno, nota1, frequencia, trabalho, projeto, notafinal, situacao);
        //resp.getWriter().append(situacao(frequencia, nota1, trabalho, projeto, notafinal ));
        
        resp.getWriter().append("<html>");
        resp.getWriter().append("<head>");
        resp.getWriter().append("<style>");
        resp.getWriter().append("table{background-color: #66CDAA; border-collapse: collapse; font-family: Verdana 14; padding: 100px; margin-top: 100px; width: 1000px;}");
        resp.getWriter().append("</style>");
        resp.getWriter().append("</head>");
        
            resp.getWriter().append("<body>");
                resp.getWriter().append("<table border='1px solid black collapse' >");
                    resp.getWriter().append("<tr>");
                        resp.getWriter().append("<td>Aluno</td>");
                        resp.getWriter().append("<td>Frequencia</td>");
                        resp.getWriter().append("<td>Nota 1</td>");
                        resp.getWriter().append("<td>Trabalho</td>");
                        resp.getWriter().append("<td>Projeto</td>");
                        resp.getWriter().append("<td>Média</td>");
                        resp.getWriter().append("<td>Prova Final</td>");                       
                        resp.getWriter().append("<td>Situacao</td>");
                    
                    for (int i = 0; i < a.size(); i++) {
                
                    resp.getWriter().append("</tr>");
                    
                    resp.getWriter().append("<tr>");
                        resp.getWriter().append("<td>" + a.get(i).getNome() + "</td>");
                        resp.getWriter().append("<td>" + a.get(i).getFrequencia() + "</td>");
                        resp.getWriter().append("<td>" + a.get(i).getNota1() + "</td>");
                        resp.getWriter().append("<td>" + a.get(i).getTrabalho() + "</td>");
                        resp.getWriter().append("<td>" + a.get(i).getProjeto() + "</td>");
                        resp.getWriter().append("<td>" + a.get(i).getM1() + "</td>");
                        resp.getWriter().append("<td>" + a.get(i).getNotafinal() + "</td>");
                        
                        resp.getWriter().append("<td>" + a.get(i).getSituacao() + "</td>");

      
                    resp.getWriter().append("</tr>");
                    
                    }  
                    
                resp.getWriter().append("</table>");
            resp.getWriter().append("</body>");
        resp.getWriter().append("</html>");
        
         
        }catch(Exception e){
            
            //resp.getWriter().print("erro");
        }
        
    }
    
       /**
 *
 * Metodo que retorna a situacao de um Aluno
 * frequencia = frequencia de presenca do aluno nas aulas
 * p1 = nota da primeira prova
 * trabalho = nota do trabalho
 * projeto = nota dos projetos feitos em aula
 * pf = nota da pf, caso o aluno tenha ficado em pf
 */
    
    public String situacao(double frequencia, double p1, double trabalho, double projeto, double pf){
         double m1 = (0.7 * ((p1 + trabalho) / 2)) + (projeto * 0.3);
         String situacao;
         
        if(frequencia >= 75){
            if(m1 >= 7) 
                situacao= "Aprovado";
            else if (m1 < 3) 
                situacao = "Reprovado";
            else{
                
                if( ((pf + m1) / 2) >= 5)
                    situacao = "Aprovado";
                else
                    situacao = "Reprovado";
            }
        }else{
            situacao= "Reprovado";
        }
    
        return situacao;
    }

    

}
