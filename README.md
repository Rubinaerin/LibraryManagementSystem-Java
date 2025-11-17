# 📚 Kütüphane Yönetim Sistemi (Java & Spring Boot)

Bu proje, Java, Spring Boot, Spring Data JPA (Hibernate) ve Thymeleaf kullanılarak geliştirilmiş, kütüphane envanterini ve üye işlemlerini yönetmek için tasarlanmış web tabanlı bir uygulamadır.

## 🌟 Temel Özellikler

* **Merkezi Yönetim Paneli:** Tüm modüllere tek bir ana sayfadan erişim.
* **Kitap Yönetimi:** Kitap ekleme, listeleme, düzenleme ve **stok takibi** (CRUD).
* **Üye Yönetimi:** Üye kayıtları ve bilgileri (CRUD).
* **Ödünç İşlemleri:** Kitap stoklarını otomatik güncelleyen ödünç verme ve iade mekanizması.
* **Teknolojiler:** Dockerize edilmiş SQL Server (Veritabanı), Gradle.

## 📸 Uygulama Ekran Görüntüleri

Projenin ana modüllerinden alınan güncel görüntüler aşağıdadır:

| Modül | Açıklama | Görüntü |
| :--- | :--- | :--- |
| **Yönetim Paneli** | Tüm kütüphane modüllerine erişim sağlayan merkezi giriş sayfası. | ![Kütüphane Yönetim Paneli](images/Ekran Resmi 2025-11-16 19.17.54.png) |
| **Kitap Listesi** | Mevcut kitapların listesi, stok durumları ve düzenleme/silme seçenekleri. | ![Kitap Listesi](images/Ekran Resmi 2025-11-16 19.18.14.png) |
| **Yeni Kitap Ekle** | Kitap kayıt formu. | ![Yeni Kitap Ekle Formu](images/Ekran Resmi 2025-11-16 19.18.38.png) |
| **Üye Listesi** | Kayıtlı üyelerin listesi ve iletişim bilgileri. | ![Üye Listesi](images/Ekran Resmi 2025-11-16 19.18.52.png) |
| **Yeni Üye Ekle** | Üye kayıt formu. | ![Yeni Üye Ekle Formu](images/Ekran Resmi 2025-11-16 19.19.07.png) |
| **Aktif Ödünç Kayıtları** | Devam eden ödünç işlemlerini gösterir ve iade butonu içerir. | ![Aktif Ödünç Kayıtları](images/Ekran Resmi 2025-11-16 19.19.52.png) |
| **Ödünç Kitap Ver Formu** | Kitap ve üye seçimi yapılarak yeni ödünç kaydı oluşturma formu. | ![Ödünç Kitap Ver Formu](images/Ekran Resmi 2025-11-16 19.20.38.png) |

## ⚙️ Kurulum ve Çalıştırma

Projeyi yerel makinenizde çalıştırmak için Java 17 ve Docker'ın kurulu olması gerekir.

1.  **Depoyu Klonlayın:**
    ```bash
    git clone [https://github.com/Rubinaerin/LibraryManagementSystem-Java.git](https://github.com/Rubinaerin/LibraryManagementSystem-Java.git)
    cd LibraryManagementSystem-Java
    ```

2.  **Veritabanını Başlatın (Docker):**
    ```bash
    docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=SizinGucluSifreniz!' -e 'MSSQL_PID=Developer' -p 1433:1433 --name sql-server-library -d [mcr.microsoft.com/mssql/server:2019-latest](https://mcr.microsoft.com/mssql/server:2019-latest)
    ```
    *(NOT: `SA_PASSWORD` kısmını kendi güçlü şifrenizle değiştirin.)*

3.  **Uygulamayı Başlatın (Gradle):**
    ```bash
    ./gradlew bootRun
    ```

4.  **Erişim:** Tarayıcınızda şu adrese gidin:
    ```
    http://localhost:8083/
    ```
