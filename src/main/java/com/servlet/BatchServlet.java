package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.Operation.BatchOperation;
import com.application.Batch;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BatchServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        BatchOperation batchOperation = null;
        try {
            batchOperation = new BatchOperation();
            if (action.equals("add")) {
                addBatch(request, response, batchOperation);
            } else if (action.equals("update")) {
                updateBatch(request, response, batchOperation);
            } else if (action.equals("delete")) {
                deleteBatch(request, response, batchOperation);
            }
            listBatches(request, response, batchOperation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listBatches(HttpServletRequest request, HttpServletResponse response, BatchOperation batchOperation) throws ServletException, IOException {
        try {
            List<Batch> batches = batchOperation.ViewAllBatch();
            request.setAttribute("batchList", batches);
            request.getRequestDispatcher("ViewBatch.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addBatch(HttpServletRequest request, HttpServletResponse response, BatchOperation batchOperation) throws ServletException, IOException {
        try {
        	String id=request.getParameter("id");
            String name = request.getParameter("name");
            String time = request.getParameter("time");
            Batch batch = new Batch();
            batch.setId(Integer.parseInt(id));
            batch.setName(name);
            batch.setTime(time);
            String result = batchOperation.AddNewBatch(batch);
            request.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateBatch(HttpServletRequest request, HttpServletResponse response, BatchOperation batchOperation) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String time = request.getParameter("time");
            Batch batch = new Batch();
            batch.setId(id);
            batch.setName(name);
            batch.setTime(time);
            String result = batchOperation.UpdateBatch(batch);
            request.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            List<Integer> batchIds = batchOperation.getAllBatchIds();
            request.setAttribute("batchIds", batchIds);
            request.getRequestDispatcher("UpdateBatch.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException appropriately
        }
    }

    private void deleteBatch(HttpServletRequest request, HttpServletResponse response, BatchOperation batchOperation) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String result = batchOperation.DeleteBatch(id);
            request.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
