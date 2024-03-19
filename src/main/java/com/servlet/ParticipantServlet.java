package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Operation.ParticipantOperation;
import com.application.Participant;

public class ParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ParticipantServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ParticipantOperation participantOperation = null;
        try {
            participantOperation = new ParticipantOperation();
            if (action.equals("add")) {
                addParticipant(request, response, participantOperation);
            } else if (action.equals("update")) {
                updateParticipant(request, response, participantOperation);
            } else if (action.equals("delete")) {
                deleteParticipant(request, response, participantOperation);
            }
            listParticipants(request, response, participantOperation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listParticipants(HttpServletRequest request, HttpServletResponse response, ParticipantOperation participantOperation) throws ServletException, IOException {
        try {
            List<Participant> participants = participantOperation.getAllParticipants();
            request.setAttribute("participantList", participants);
            request.getRequestDispatcher("ViewParticipant.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addParticipant(HttpServletRequest request, HttpServletResponse response, ParticipantOperation participantOperation) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String batchId = request.getParameter("batchId");
            
            Participant participant = new Participant();
            participant.setId(Integer.parseInt(id));
            participant.setName(name);
            participant.setEmail(email);
            participant.setPhoneNumber(phoneNumber);
            participant.setBatchId(Integer.parseInt(batchId));

            String result = participantOperation.addNewParticipant(participant);
            request.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateParticipant(HttpServletRequest request, HttpServletResponse response, ParticipantOperation participantOperation) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            int batchId = Integer.parseInt(request.getParameter("batchId"));
            
            Participant participant = new Participant();
            participant.setId(id);
            participant.setName(name);
            participant.setEmail(email);
            participant.setPhoneNumber(phoneNumber);
            participant.setBatchId(batchId);
            
            String result = participantOperation.updateParticipant(participant);
            request.setAttribute("result", result);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
        	List<Integer> paIds = participantOperation.getAllParticipantIds();
        	request.setAttribute("paIds",  paIds );
        	request.getRequestDispatcher("UpdateParticipant.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    
    private void deleteParticipant(HttpServletRequest request, HttpServletResponse response, ParticipantOperation participantOperation) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String result = participantOperation.deleteParticipant(id);
            request.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
