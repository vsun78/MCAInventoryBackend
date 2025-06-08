package com.inv.inventorysoftware;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventorySoftwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventorySoftwareApplication.class, args);
    }
    /*
    // This method runs after the app starts and inserts test items
    @Bean // tells Spring Boot that this is a special method that runs when the application starts
    public CommandLineRunner loadTheData(ItemRepository repo) { // CommandLineRunner runs a block of code right after the app finishes starting
        return args -> {
            // ItemRepository repo argument above is so that Spring automatically gives you an instance of ItemRepository
            // without having to "new" anything

            if (repo.count() == 0) { // ✅ prevents overwriting data if it already exists

                repo.save(new Item(
                        "MacBook Pro", "123a" ,4,
                        "M1 2021", "Assigned to Engineering Lab",
                        "https://www.apple.com/newsroom/images/tile-images/Apple_16-inch-MacBook-Pro_111319.jpg.landing-big_2x.jpg"
                )); // saves the Item object to the database

                // also note new Item is what creates the new item
                // the data is now available to the API and the frontend

                repo.save(new Item(
                        "Dell Monitor", "123aa" , 9,
                        "Dell UltraSharp U2723QE", "In storage, ready for deployment",
                        "https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/dell-client-products/peripherals/monitors/s-series/se2725h/media-gallery/monitor-dell-se2725h-gallery-1.psd?fmt=pjpg&pscan=auto&scl=1&wid=3380&hei=2925&qlt=100,1&resMode=sharp2&size=3380,2925&chrss=full&imwidth=5000"
                ));

                repo.save(new Item(
                        "Logitech Keyboard", "123aaa" ,12,
                        "K400 Plus", "Spare stock in locker room",
                        "https://m.media-amazon.com/images/I/71dG6Pal5XL.jpg"
                ));

                repo.save(new Item(
                        "iPad", "234a" , 2,
                        "Lenovo X1 Carbon", "Broken screen — needs repair",
                        "https://store.storeimages.cdn-apple.com/1/as-images.apple.com/is/ipad-finish-select-202503-blue-wifi_FMT_WHH?wid=1200&hei=630&fmt=jpeg&qlt=95&.v=1739318906885"
                ));

                repo.save(new Item(
                        "Mouse", "234aa", 7,
                        "HP 9025e", "Used in admin office",
                        "https://www.vortez.net/articles_file/40596_logitech_g305_review_box_front.jpg"
                ));

                repo.save(new Item(
                        "Extreme Network – Big", "234aaa", 1,
                        "N/A", "Big",
                        "https://www.netsolutionstore.com/images/products/Extreme-Networks-AP4000-WiFi6.png"
                ));

                repo.save(new Item(
                        "Extreme Network – Small", "436a", 3,
                        "N/A", "Small",
                        "https://www.cnet.com/a/img/resize/6ff38a667e684fa6707c3de87d0c8c3d1e54dceb/hub/2009/10/23/967497b0-954f-4614-bbc7-28c1fe404e8d/apple-airport-extreme-base-station-wireless-access-point-802-11-a-b-g-n-draft-for-imac-iphone-ipod-touch-mac-mini-mac-pro.jpg?auto=webp&fit=crop&height=675&width=1200"
                ));

                repo.save(new Item(
                        "Headphones", "43a6a", 12,
                        "N/A", "",
                        "https://assets2.jabra.com/f/4/2/a/f42adab61aa9a78e2d32ccca263650401d93a02c_Jabra_Evolve2_65_UC_Stereo_black_03.png?w=585&h=585&auto=format,compress"
                ));

                repo.save(new Item(
                        "Puck Dock", "125", 9,
                        "N/A", "",
                        "https://pcorder.snapon.com/cdn/shop/files/DA310_2_grande.png?v=1689971097"
                ));

                repo.save(new Item(
                        "Docking Station", "43dd6a", 6,
                        "N/A", "",
                        "https://i.dell.com/is/image/DellContent/content/dam/images/products/electronics-and-accessories/dell/docks-and-stands/wd22tb4/wd22tb4-xnb-05-bk.psd?fmt=png-alpha&wid=4911&hei=2365"
                ));

                repo.save(new Item(
                        "Webcam", "4awd36a", 17,
                        "N/A", "Logitech Webcam",
                        "https://ccimg.canadacomputers.com/Products/800x800/235/565/105280/87191.jpg"
                ));

                repo.save(new Item(
                        "Voice Amplifier", "43ddds6a", 2,
                        "N/A", "Zoweetek Voice Amplifier",
                        "https://m.media-amazon.com/images/I/7193Kw0j8dL._AC_UF1000,1000_QL80_.jpg"
                ));

                repo.save(new Item(
                        "iPhone", "4136a", 7,
                        "N/A", "iPhone 14",
                        "https://m.media-amazon.com/images/I/61KXZ+vfu3L.jpg"
                ));


            }
        };
    }
    -- old --
     */
// This method runs after the app starts and inserts test items
    @Bean // tells Spring Boot that this is a special method that runs when the application starts

    public CommandLineRunner loadTheData(ItemRepository repo) { // CommandLineRunner runs a block of code right after the app finishes starting
        return args -> {
            // ItemRepository repo argument above is so that Spring automatically gives you an instance of ItemRepository
            // without having to "new" anything

            if (repo.count() == 0) { //  prevents overwriting data if it already exists

                repo.save(new Item(
                        "MacBook Pro", "L01", 4,
                        "M1 2021", "Assigned to Engineering Lab",
                        "https://www.apple.com/newsroom/images/tile-images/Apple_16-inch-MacBook-Pro_111319.jpg.landing-big_2x.jpg"
                )); // saves the Item object to the database

                // also note new Item is what creates the new item
                // the data is now available to the API and the frontend

                repo.save(new Item(
                        "Dell Monitor", "M01", 9,
                        "Dell UltraSharp U2723QE", "In storage, ready for deployment",
                        "https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/dell-client-products/peripherals/monitors/s-series/se2725h/media-gallery/monitor-dell-se2725h-gallery-1.psd?fmt=pjpg&pscan=auto&scl=1&wid=3380&hei=2925&qlt=100,1&resMode=sharp2&size=3380,2925&chrss=full&imwidth=5000"
                ));

                repo.save(new Item(
                        "Logitech Keyboard", "K01", 12,
                        "K400 Plus", "New hires coming next week, will need more",
                        "https://m.media-amazon.com/images/I/71dG6Pal5XL.jpg"
                ));

                repo.save(new Item(
                        "iPad", "L02", 2,
                        "9th Generation", "Broken screen — needs repair",
                        "https://store.storeimages.cdn-apple.com/1/as-images.apple.com/is/ipad-finish-select-202503-blue-wifi_FMT_WHH?wid=1200&hei=630&fmt=jpeg&qlt=95&.v=1739318906885"
                ));

                repo.save(new Item(
                        "Mouse", "P01", 7,
                        "N/A", "Used in admin office",
                        "https://www.vortez.net/articles_file/40596_logitech_g305_review_box_front.jpg"
                ));

                repo.save(new Item(
                        "Extreme Network", "T01", 3,
                        "N/A", "BIG",
                        "https://www.cnet.com/a/img/resize/6ff38a667e684fa6707c3de87d0c8c3d1e54dceb/hub/2009/10/23/967497b0-954f-4614-bbc7-28c1fe404e8d/apple-airport-extreme-base-station-wireless-access-point-802-11-a-b-g-n-draft-for-imac-iphone-ipod-touch-mac-mini-mac-pro.jpg?auto=webp&fit=crop&height=675&width=1200"
                ));

                repo.save(new Item(
                        "Extreme Network", "T02", 1,
                        "N/A", "SMALL",
                        "https://extr-p-001.sitecorecontenthub.cloud/api/public/content/4e60ce4d947b41eea29b2b068e2c8ea9?v=44dc78a2"
                ));

                repo.save(new Item(
                        "Wireless Headset", "T03", 16,
                        "N/A", "This item runs out fast, keep an eye on it",
                        "https://webobjects2.cdw.com/is/image/CDW/8114342?$product-main$"
                ));

                repo.save(new Item(
                        "iPad Charger", "T04", 5,
                        "N/A", "12W",
                        "https://www.canadiancellparts.com/wp-content/uploads/2024/09/iPad-Charging-Block-10W.png"
                ));

                repo.save(new Item(
                        "Webcam", "T05", 12,
                        "N/A", "Logitech Webcam",
                        "https://ccimg.canadacomputers.com/Products/800x800/235/565/105280/87191.jpg"
                ));

                repo.save(new Item(
                        "Puck Dock", "T06", 9,
                        "N/A", "Dell",
                        "https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/peripherals/output-devices/dell/adapters/dell-da310-ubs-c-adapter/pdp/dell-da310-usb-c-adapter-pdp-campaign-hero-504x350.jpg?hei=402&qtl=90,0&op_usm=1.75,0.3,2,0&resMode=sharp&pscan=auto"
                ));

                repo.save(new Item(
                        "Docking Station", "T07", 7,
                        "N/A", "USB-C",
                        "https://i.dell.com/is/image/DellContent/content/dam/images/products/electronics-and-accessories/dell/docks-and-stands/wd22tb4/wd22tb4-xnb-05-bk.psd?fmt=png-alpha&wid=4911&hei=2365"
                ));

                repo.save(new Item(
                        "Voice Amplifier", "T08", 3,
                        "N/A", "Zoweetek Voice Amplifier",
                        "https://m.media-amazon.com/images/I/71xJIfDOTLL._AC_UF894,1000_QL80_.jpg"
                ));

                repo.save(new Item(
                        "Ethernet Cable", "T09", 52,
                        "N/A", "CAT6, 100W",
                        "https://media.startech.com/cms/products/gallery_large/n6patcxmbl.main.jpg"
                ));

                repo.save(new Item(
                        "iPhone", "T10", 7,
                        "N/A", "iPhone 14",
                        "https://shop.simplyfixit.ca/cdn/shop/products/apple-iphone-14-plus-3.jpg?v=1698712218"
                ));

            } //temp
        };
    }
}
