package rikkei.ra.config;

public class Constatnt {
    public enum productQuery {
        FIND_ALL("SELECT * FROM products WHERE isDelete = 0"),
        ADD_NEW("INSERT INTO products(productName, description, price) VALUES(?, ?, ?)"),
        FIND_ONE("SELECT * FROM products WHERE productId = ?"),
        UPDATE("UPDATE products SET productName = ?, description = ?, price = ? WHERE productId = ?"),
        DELETE("UPDATE products SET isDelete = 1 WHERE productId = ?");

        private final String query;

        productQuery(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }
}
