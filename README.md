# 📚 Kütüphane Yönetim Sistemi (Library Management System)

Bu proje, Spring Boot, Spring Data JPA ve Thymeleaf kullanılarak geliştirilmiş tam özellikli bir Kütüphane Yönetim Sistemi web uygulamasıdır. Kullanıcıların kitapları, üyeleri ve ödünç alma/iade işlemlerini kolayca yönetmesini sağlar.

## 🌟 Temel Özellikler

* **Kitap Yönetimi:** Yeni kitap ekleme, mevcut kitapları listeleme, güncelleme ve silme (CRUD).
* **Üye Yönetimi:** Kütüphane üyelerini kaydetme, düzenleme ve silme (CRUD).
* **Ödünç/İade İşlemleri:** Kitapları üyelere ödünç verme ve iade kayıtlarını tutma.
* **Arayüz:** Temiz ve Bootstrap tabanlı kullanıcı arayüzü (Thymeleaf ile).

## 🛠️ Kullanılan Teknolojiler

| Teknoloji | Açıklama |
| :--- | :--- |
| **Backend** | Java 17 |
| **Framework** | Spring Boot 3 |
| **Veritabanı** | Spring Data JPA (H2 In-Memory Database) |
| **Şablon Motoru** | Thymeleaf |
| **Arayüz** | HTML5, Bootstrap 4 |
| **Bağımlılık Yöneticisi** | Gradle |

## 📸 Uygulama Ekran Görüntüleri

Projenin temel modüllerinden alınan ekran görüntüleri aşağıdadır:

### Ana Panel
Uygulamanın ana sayfası. Buradan tüm modüllere erişilebilir.
![Ana Sayfa Ekran Görüntüsü](images/ana_panel.png) 
*(NOT: Lütfen bu kısma Ana Panelinizin ekran görüntüsünü yükleyin)*

### Kitap Listesi
Kütüphanedeki tüm kitapların listelendiği, arama ve düzenleme yapılabilen sayfa.
![Kitap Listesi Ekran Görüntüsü](images/kitap_listesi.png)
*(NOT: Lütfen bu kısma Kitap Listesi sayfanızın ekran görüntüsünü yükleyin)*

### Ödünç Alma Formu
Yeni bir kitap ödünç alma kaydının yapıldığı form.
![Ödünç Formu Ekran Görüntüsü](images/odunc_formu.png)
*(NOT: Lütfen bu kısma Ödünç Alma Formu sayfanızın ekran görüntüsünü yükleyin)*

## ⚙️ Yerel Kurulum ve Çalıştırma

Projeyi yerel makinenizde çalıştırmak için aşağıdaki adımları takip edin:

1.  **Projeyi Klonlayın:**
    ```bash
    git clone [https://github.com/Rubinaerin/LibraryManagementSystem-Java.git](https://github.com/Rubinaerin/LibraryManagementSystem-Java.git)
    cd LibraryManagementSystem-Java
    ```
2.  **Uygulamayı Çalıştırın:** Projenin ana dizininde (build.gradle dosyasının bulunduğu yer) terminali açın ve aşağıdaki komutu çalıştırın:
    ```bash
    ./gradlew bootRun
    ```
3.  **Erişim:** Uygulama başarıyla başlatıldıktan sonra tarayıcınızda şu adrese gidin:
    ```
    http://localhost:8083/
    ```

---

## 🖼️ Ekran Görüntülerini Ekleme

README dosyasında ekran görüntülerinizin görünmesi için, projenizin ana dizininde (build.gradle'ın olduğu yer) **`images`** adında yeni bir klasör oluşturmanız ve içine ekran görüntülerini kaydetmeniz gerekir.

1.  Projenizin ana klasöründe yeni bir klasör oluşturun:
    ```bash
    mkdir images
    ```
2.  Ekran görüntülerinizi bu `images` klasörüne kopyalayın ve isimlerini README dosyasındaki gibi yapın:
    * `ana_panel.png`
    * `kitap_listesi.png`
    * `odunc_formu.png`

## 3. 💾 Değişiklikleri GitHub'a Yükleme

`README.md` dosyasını ve `images` klasörünü oluşturduktan sonra, bu yeni dosyaları GitHub'a göndermeliyiz:

```bash
# Yeni dosyaları takibe ekle
git add README.md images/

# Değişiklikleri kaydet
git commit -m "feat: Add comprehensive README and screenshots"

# GitHub'a yükle (Bu komut başarılı olmalı, çünkü depo zaten var)
git push origin main
