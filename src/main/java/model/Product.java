package model;

import java.util.LinkedList;
import java.util.List;

public class Product {
    private int detailID;
    private int productID;
    private String productName;
    private String description;
    private int status;
    private List<String> images;

    public Product() {
        images = new LinkedList<>();
    }

    public Product(int detailID, int productID, String productName, String description, int status, List<String> images) {
        this.detailID = detailID;
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.status = status;
        this.images = images;
    }

    public Product(int productID, String productName, String description, int status, List<String> images) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.status = status;
        this.images = images;
    }


    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void addImages(String imageLink) {
        images.add(imageLink);
    }
}
