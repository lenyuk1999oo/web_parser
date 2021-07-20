package model;

import java.util.ArrayList;

public class Think {

    private String articleID;
    private String productName;
    private String brand;
    private String price;
    private ArrayList<String> colors;
    private ArrayList<String> sizes;
    private String imgURL;


    public Think() {
        colors = new ArrayList<>();
        sizes = new ArrayList<>();
    }


    public String getArticleID() {
        return articleID;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public ArrayList<String> getSizes() {
        return sizes;
    }

    public String getImgURL() {
        return imgURL;
    }


    public Think setArticleID(String articleID) {
        this.articleID = articleID;
        return this;
    }

    public Think setImgURL(String imgURL) {
        this.imgURL = imgURL;
        return this;
    }

    public Think setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Think setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Think setPrice(String price) {
        this.price = price;
        return this;
    }

    public Think setColors(ArrayList<String> colors) {
        this.colors = colors;
        return this;
    }

    public Think setSizes(ArrayList<String> sizes) {
        this.sizes = sizes;
        return this;
    }


    @Override
    public String toString() {
        return "model.Think{" +
                "articleID='" + articleID + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", colors=" + colors +
                ", sizes=" + sizes +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
