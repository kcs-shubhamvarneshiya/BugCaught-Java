package com.example.demo.PdfExportor;

import java.awt.Color;
import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.report;
import com.lowagie.text.*;
import com.lowagie.text.html.WebColors;
import com.lowagie.text.pdf.*;

public class ProjectReportPdfExport {

	private report reportData;

	public ProjectReportPdfExport(report reportData) {
		// TODO Auto-generated constructor stub
		this.reportData = reportData;

	}

	/* Table Header */
	private void WriteTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();

		cell.setBackgroundColor(WebColors.getRGBColor("#4b4276"));
		cell.setPadding(7);
		cell.setBorderColor(Color.white);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Id", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Project Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Status", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Start Date", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("End Date", font));
		table.addCell(cell);

	}

	/* Write Data Into Table */
	private void writeTableData(PdfPTable table) {
		table.setHorizontalAlignment(10);
		table.addCell(String.valueOf(reportData.getRid()));
		table.addCell(reportData.getPid().getProject_name());
		table.addCell(reportData.getStatus());
		table.addCell(reportData.getStartdate());
		table.addCell(reportData.getEnddate());
		
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLACK);

		Paragraph p = new Paragraph("Project Report", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 0.5f, 3.0f, 1.7f, 2.0f, 2.0f });
		table.setSpacingBefore(20);

		WriteTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();
	}

}
