package Model;

import BusinessLogic.ClientBLL;
import BusinessLogic.ProductBLL;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * The type Bill.
 */
public record Bill(Order order) {

    /**
     * Write to file log.
     *
     * @param id the id
     */
    public void writeToLog(int id) {

        String file_path = "order_log" + id + ".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(file_path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.open();

        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        Client client = (new ClientBLL()).findClientById(order().getId_client());
        Product product = (new ProductBLL()).findProductById(order().getId_product());

        Chunk chunk1 = new Chunk("--- ORDER " + id + " ---\n", font);
        Chunk chunk2 = new Chunk("Client name: " + client.getName(), font);
        Chunk chunk3 = new Chunk("Address: " + client.getAddress(), font);
        Chunk chunk4 = new Chunk("Phone number: " + client.getPhone_number(), font);
        Chunk chunk5 = new Chunk("Product name: " + product.getName(), font);
        Chunk chunk6 = new Chunk("Price: " + product.getPrice(),font);
        Chunk chunk7 = new Chunk("Quantity: " + order.getQuantity(), font);

        try {
            document.add(new Paragraph(chunk1));
            document.add(new Paragraph(chunk2));
            document.add(new Paragraph(chunk3));
            document.add(new Paragraph(chunk4));
            document.add(new Paragraph(chunk5));
            document.add(new Paragraph(chunk6));
            document.add(new Paragraph(chunk7));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        document.close();
    }

}
