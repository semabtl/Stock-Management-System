# STOK TAKİP SİSTEMİ
## Projenin Genel Özellikleri
Bu projede, firmaların ürün, sipariş ve stok takibi yapabilecekleri bir web sitesi oluşturulmuştur. Projede Anasayfa, Ürün Yönetimi, Satın Alma Yönetimi ve Kullanıcı Yönetimi modülleri bulunmaktadır. Bu modüllerde bulunan alt modüller aşağıda listelenmiştir.

**1.** Ürün Yönetimi
- Ürün Ekleme
- Ürün Listeleme 
- Stok Görüntüleme
- Barkod Yazdırma
  
**2.** Satın Alma Yönetimi 
- Sipariş Oluşturma 
  - Sepete Ürün Ekleme 
  - Sepeti Görüntüleme
- Sipariş Listeleme
  
**3.** Kullanıcı Yönetimi
- Giriş Yapma
- Kaydolma

## Projede Kullanılan Teknolojiler
Projede Java programlama dili kullanılmıştır. Frontend kısmında JSP sayfaları kullanılmıştır. Servlet yapısıyla JSP sayfalarından gelen bilgiler ve hareketler yönetilmiştir. Veri tabanı yönetimi için PostgreSQL kullanılmıştır.
Projenin web projesi olarak çalıştırılması için Tomcat web server kullanılmıştır.

## Projenin Geliştirilmesi ve Çalıştırılabilmesi için Hazırlanan Ortam
Öncelikle bilgisayara Apache Tomcat uygulaması kurulmuştur. Tomcat, Java EE spesifikasyonlarını çalıştırmayı sağlayan bir web server olarak tanımlanır. Bunlar arasında Java Servlet ve Java Server Pages (JSP) yer almaktadır. Yapılacak olan projede kullanılacak olan uygulamalar da bunlardır. 

Tomcat kurulumu sonrası Eclipse IDE üzerinde server konfigürasyonu yapılmıştır. Eclipse üzerinden web projesi yazmak ve çalıştırmak için Install New Software kısmından “Web, XML, Java EE and OSGi Enterprise Development” eklentisi indirilmiştir. Bu işlemlerin ardından Eclipse üzerinden Dynamic Web Project oluşturularak proje dosyası oluşturulmuştur. Daha sonra proje Maven projesine çevrilmiştir. Ardından proje için kodlama aşamasına geçilmiştir.

## Kullanıcı Arayüzü Ekran Görüntüleri
### Anasayfa

![picture-1](Screenshots/1.png)

Kullanıcı giriş yapmadıysa, Ürün Yönetimi(Product Management) ve Satın Alma Yönetimi(Purchase Management) sayfalarına erişememektedir. Bu sayfalara tıkladığında karşısına Kullanıcı Yönetimi(User Management) sayfası çıkmaktadır. Bu sayfada giriş yapma ve kaydolma seçenekleri bulunmaktadır.

### Kullanıcı Yönetimi

![picture-2](Screenshots/2.png)

### Giriş Yapma Sayfası

![picture-3](Screenshots/3.png)

### Kaydolma Sayfası

![picture-4](Screenshots/4.png)

### Ürün Yönetimi Sayfası

![picture-5](Screenshots/5.png)

### Ürün Ekleme Sayfası

![picture-13](Screenshots/13_3.png)

### Ürünleri Listeleme Sayfası

![picture-10](Screenshots/10_3.png)

### Detayları Göster Seçeneği Seçilirse

![picture-14](Screenshots/14_3.png)


