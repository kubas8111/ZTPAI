package com.example.adwise.loader;

import com.example.adwise.entities.*;
import com.example.adwise.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoadDatabase implements CommandLineRunner {
    private final AnnouncementRepository announcementRepository;
    private final CategoryRepository categoryRepository;
    private final CommentRepository commentRepository;
    private final ImageRepository imageRepository;
    private final ProfileRepository profileRepository;
    private final RegionRepository regionRepository;
    private final TagRepository tagRepository;
    private final PasswordEncoder passwordEncoder;

    public LoadDatabase(ProfileRepository profileRepository, AnnouncementRepository announcementRepository, CategoryRepository categoryRepository, CommentRepository commentRepository, ImageRepository imageRepository, TagRepository tagRepository, RegionRepository regionRepository, PasswordEncoder passwordEncoder) {
        this.profileRepository = profileRepository;
        this.announcementRepository = announcementRepository;
        this.categoryRepository = categoryRepository;
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
        this.tagRepository = tagRepository;
        this.regionRepository = regionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.profileRepository.findByEmail("admin@admin.com") == null) {
            saveProfiles();
            saveCategories();
            saveTags();
            saveRegions();
            saveAnnouncements();
            saveComments();
            saveImages();
        }
    }

    private void saveProfiles() {
        this.profileRepository.save(new Profile(null, "admin@admin.com", passwordEncoder.encode("admin"), "admin", "mleb", "3433344344", true));
        this.profileRepository.save(new Profile(null, "user@user.com", passwordEncoder.encode("user"), "user", "u", "11234123", false));
        this.profileRepository.save(new Profile(null, "john.doe@example.com", passwordEncoder.encode("password1"), "John", "Doe", "123456789", false));
        this.profileRepository.save(new Profile(null, "jane.smith@example.com", passwordEncoder.encode("password2"), "Jane", "Smith", "987654321", false));
        this.profileRepository.save(new Profile(null, "mike.johnson@example.com", passwordEncoder.encode("password3"), "Mike", "Johnson", "555666777", false));
    }

    private void saveCategories() {
        this.categoryRepository.save(new Category(null, "Motoryzacja"));
        this.categoryRepository.save(new Category(null, "Nieruchomości"));
        this.categoryRepository.save(new Category(null, "Praca"));
        this.categoryRepository.save(new Category(null, "Elektronika"));
        this.categoryRepository.save(new Category(null, "Moda i Uroda"));
        this.categoryRepository.save(new Category(null, "Usługi"));
        this.categoryRepository.save(new Category(null, "Dom i Ogród"));
        this.categoryRepository.save(new Category(null, "Sport i Rekreacja"));
        this.categoryRepository.save(new Category(null, "Edukacja"));
        this.categoryRepository.save(new Category(null, "Zwierzęta"));
    }

    private void saveTags() {
        this.tagRepository.save(new Tag(null, "Sprzedaż"));
        this.tagRepository.save(new Tag(null, "Wynajem"));
        this.tagRepository.save(new Tag(null, "Usługi"));
        this.tagRepository.save(new Tag(null, "Praca"));
    }

    private void saveRegions() {
        this.regionRepository.save(new Region(null, "Dolnośląskie"));
        this.regionRepository.save(new Region(null, "Kujawsko-Pomorskie"));
        this.regionRepository.save(new Region(null, "Lubelskie"));
        this.regionRepository.save(new Region(null, "Lubuskie"));
        this.regionRepository.save(new Region(null, "Łódzkie"));
        this.regionRepository.save(new Region(null, "Małopolskie"));
        this.regionRepository.save(new Region(null, "Mazowieckie"));
        this.regionRepository.save(new Region(null, "Opolskie"));
        this.regionRepository.save(new Region(null, "Podkarpackie"));
        this.regionRepository.save(new Region(null, "Podlaskie"));
        this.regionRepository.save(new Region(null, "Pomorskie"));
        this.regionRepository.save(new Region(null, "Śląskie"));
        this.regionRepository.save(new Region(null, "Świętokrzyskie"));
        this.regionRepository.save(new Region(null, "Warmińsko-Mazurskie"));
        this.regionRepository.save(new Region(null, "Wielkopolskie"));
        this.regionRepository.save(new Region(null, "Zachodniopomorskie"));
    }

    private void saveAnnouncements() {
        Profile profile2 = this.profileRepository.findById(2L).orElseThrow();
        Profile profile3 = this.profileRepository.findById(3L).orElseThrow();
        Profile profile4 = this.profileRepository.findById(4L).orElseThrow();
        Profile profile5 = this.profileRepository.findById(5L).orElseThrow();

        Category category1 = this.categoryRepository.findById(1L).orElseThrow();
        Category category2 = this.categoryRepository.findById(2L).orElseThrow();
        Category category3 = this.categoryRepository.findById(3L).orElseThrow();
        Category category4 = this.categoryRepository.findById(4L).orElseThrow();

        Tag tag1 = this.tagRepository.findById(1L).orElseThrow();
        Tag tag2 = this.tagRepository.findById(2L).orElseThrow();
        Tag tag3 = this.tagRepository.findById(3L).orElseThrow();
        Tag tag4 = this.tagRepository.findById(4L).orElseThrow();

        Region region1 = this.regionRepository.findById(1L).orElseThrow();
        Region region2 = this.regionRepository.findById(2L).orElseThrow();
        Region region3 = this.regionRepository.findById(3L).orElseThrow();
        Region region4 = this.regionRepository.findById(4L).orElseThrow();
        Region region5 = this.regionRepository.findById(5L).orElseThrow();
        Region region6 = this.regionRepository.findById(6L).orElseThrow();
        Region region7 = this.regionRepository.findById(7L).orElseThrow();
        Region region8 = this.regionRepository.findById(8L).orElseThrow();
        Region region9 = this.regionRepository.findById(9L).orElseThrow();
        Region region10 = this.regionRepository.findById(10L).orElseThrow();
        Region region11 = this.regionRepository.findById(11L).orElseThrow();
        Region region12 = this.regionRepository.findById(12L).orElseThrow();
        Region region13 = this.regionRepository.findById(13L).orElseThrow();
        Region region14 = this.regionRepository.findById(14L).orElseThrow();
        Region region15 = this.regionRepository.findById(15L).orElseThrow();
        Region region16 = this.regionRepository.findById(16L).orElseThrow();

        this.announcementRepository.save(new Announcement(null, profile2, category1, region1, tag1, "Sprzedaż domu w Warszawie", 100000.0, "Dom na sprzedaż w Warszawie, 120 m2", new Date(), true, "Jan Kowalski", "jan.kowalski@example.com", "111-111-111"));
        this.announcementRepository.save(new Announcement(null, profile3, category3, region2, tag2, "Wynajem mieszkania w Krakowie", 2000.0, "Mieszkanie na wynajem, 50 m2, Kraków", new Date(), true, "Anna Nowak", "anna.nowak@example.com", "222-222-222"));
        this.announcementRepository.save(new Announcement(null, profile4, category3, region3, tag3, "Praca jako programista w Poznaniu", 6000.0, "Szukamy programisty Java, Poznań", new Date(), true, "Piotr Wiśniewski", "piotr.wisniewski@example.com", "333-333-333"));
        this.announcementRepository.save(new Announcement(null, profile5, category2, region4, tag4, "Usługi budowlane w Gdańsku", 400.0, "Oferujemy usługi budowlane, Gdańsk", new Date(), true, "Katarzyna Zielińska", "katarzyna.zielinska@example.com", "444-444-444"));
        this.announcementRepository.save(new Announcement(null, profile2, category1, region5, tag1, "Sprzedaż samochodu w Wrocławiu", 50000.0, "Samochód na sprzedaż, Wrocław", new Date(), true, "Tomasz Kowal", "tomasz.kowal@example.com", "555-555-555"));
        this.announcementRepository.save(new Announcement(null, profile3, category2, region6, tag2, "Wynajem biura w Łodzi", 3000.0, "Biuro do wynajęcia, Łódź", new Date(), true, "Aleksandra Lewandowska", "aleksandra.lewandowska@example.com", "666-666-666"));
        this.announcementRepository.save(new Announcement(null, profile4, category1, region7, tag3, "Sprzedaż działki w Szczecinie", 150000.0, "Działka na sprzedaż, Szczecin", new Date(), true, "Robert Woźniak", "robert.wozniak@example.com", "777-777-777"));
        this.announcementRepository.save(new Announcement(null, profile5, category2, region8, tag4, "Usługi ogrodnicze w Bydgoszczy", 200.0, "Oferujemy usługi ogrodnicze, Bydgoszcz", new Date(), true, "Barbara Wójcik", "barbara.wojcik@example.com", "888-888-888"));
        this.announcementRepository.save(new Announcement(null, profile2, category3, region9, tag1, "Praca jako nauczyciel w Lublinie", 5000.0, "Szukamy nauczyciela matematyki, Lublin", new Date(), true, "Andrzej Kamiński", "andrzej.kaminski@example.com", "999-999-999"));
        this.announcementRepository.save(new Announcement(null, profile3, category1, region10, tag2, "Sprzedaż mieszkania w Katowicach", 300000.0, "Mieszkanie na sprzedaż, Katowice", new Date(), true, "Monika Kaczmarek", "monika.kaczmarek@example.com", "101-101-101"));
        this.announcementRepository.save(new Announcement(null, profile4, category3, region11, tag3, "Praca jako księgowy w Opolu", 4500.0, "Szukamy księgowego, Opole", new Date(), true, "Michał Król", "michal.krol@example.com", "111-111-112"));
        this.announcementRepository.save(new Announcement(null, profile5, category4, region12, tag4, "Usługi transportowe w Rzeszowie", 120.0, "Oferujemy usługi transportowe, Rzeszów", new Date(), true, "Ewa Dąbrowska", "ewa.dabrowska@example.com", "121-121-121"));
        this.announcementRepository.save(new Announcement(null, profile2, category1, region13, tag1, "Sprzedaż laptopa w Białymstoku", 3000.0, "Laptop na sprzedaż, Białystok", new Date(), true, "Wojciech Szymański", "wojciech.szymanski@example.com", "131-131-131"));
        this.announcementRepository.save(new Announcement(null, profile3, category1, region14, tag2, "Sprzedaż roweru w Kielcach", 1500.0, "Rower na sprzedaż, Kielce", new Date(), true, "Natalia Jankowska", "natalia.jankowska@example.com", "141-141-141"));
        this.announcementRepository.save(new Announcement(null, profile4, category2, region15, tag3, "Usługi remontowe w Zielonej Górze", 700.0, "Oferujemy usługi remontowe, Zielona Góra", new Date(), true, "Łukasz Pawlak", "lukasz.pawlak@example.com", "151-151-151"));
        this.announcementRepository.save(new Announcement(null, profile5, category4, region16, tag4, "Przeprowadzki w Tarnowie", 160.0, "Oferujemy przeprowadzki, Tarnów", new Date(), true, "Patrycja Wolska", "patrycja.wolska@example.com", "161-161-161"));
    }

    private void saveComments() {
        Profile profile2 = this.profileRepository.findById(2L).orElseThrow();
        Profile profile3 = this.profileRepository.findById(3L).orElseThrow();
        Profile profile4 = this.profileRepository.findById(4L).orElseThrow();
        Profile profile5 = this.profileRepository.findById(5L).orElseThrow();

        this.commentRepository.save(new Comment(null, profile2, profile3, "Great profile!", new Date()));
        this.commentRepository.save(new Comment(null, profile3, profile4, "Nice ads!", new Date()));
        this.commentRepository.save(new Comment(null, profile4, profile5, "Very helpful!", new Date()));
        this.commentRepository.save(new Comment(null, profile5, profile2, "Thanks for the info!", new Date()));
        this.commentRepository.save(new Comment(null, profile2, profile4, "Good service!", new Date()));
        this.commentRepository.save(new Comment(null, profile3, profile5, "Highly recommended!", new Date()));
        this.commentRepository.save(new Comment(null, profile4, profile2, "Awesome!", new Date()));
        this.commentRepository.save(new Comment(null, profile5, profile3, "Very satisfied!", new Date()));
        this.commentRepository.save(new Comment(null, profile2, profile5, "Fantastic experience!", new Date()));
        this.commentRepository.save(new Comment(null, profile3, profile2, "Will use again!", new Date()));
    }

    private void saveImages() {
        Announcement announcement1 = this.announcementRepository.findById(1L).orElseThrow();
        Announcement announcement2 = this.announcementRepository.findById(2L).orElseThrow();
        Announcement announcement3 = this.announcementRepository.findById(3L).orElseThrow();
        Announcement announcement4 = this.announcementRepository.findById(4L).orElseThrow();
        Announcement announcement5 = this.announcementRepository.findById(5L).orElseThrow();
        Announcement announcement6 = this.announcementRepository.findById(6L).orElseThrow();
        Announcement announcement7 = this.announcementRepository.findById(7L).orElseThrow();
        Announcement announcement8 = this.announcementRepository.findById(8L).orElseThrow();
        Announcement announcement9 = this.announcementRepository.findById(9L).orElseThrow();
        Announcement announcement10 = this.announcementRepository.findById(10L).orElseThrow();
        Announcement announcement11 = this.announcementRepository.findById(11L).orElseThrow();
        Announcement announcement12 = this.announcementRepository.findById(12L).orElseThrow();
        Announcement announcement13 = this.announcementRepository.findById(13L).orElseThrow();
        Announcement announcement14 = this.announcementRepository.findById(14L).orElseThrow();
        Announcement announcement15 = this.announcementRepository.findById(15L).orElseThrow();
        Announcement announcement16 = this.announcementRepository.findById(16L).orElseThrow();

        this.imageRepository.save(new Image(null, announcement1, "http://example.com/image1.jpg"));
        this.imageRepository.save(new Image(null, announcement2, "http://example.com/image2.jpg"));
        this.imageRepository.save(new Image(null, announcement3, "http://example.com/image3.jpg"));
        this.imageRepository.save(new Image(null, announcement4, "http://example.com/image4.jpg"));
        this.imageRepository.save(new Image(null, announcement5, "http://example.com/image5.jpg"));
        this.imageRepository.save(new Image(null, announcement6, "http://example.com/image6.jpg"));
        this.imageRepository.save(new Image(null, announcement7, "http://example.com/image7.jpg"));
        this.imageRepository.save(new Image(null, announcement8, "http://example.com/image8.jpg"));
        this.imageRepository.save(new Image(null, announcement9, "http://example.com/image9.jpg"));
        this.imageRepository.save(new Image(null, announcement10, "http://example.com/image10.jpg"));
        this.imageRepository.save(new Image(null, announcement11, "http://example.com/image11.jpg"));
        this.imageRepository.save(new Image(null, announcement12, "http://example.com/image12.jpg"));
        this.imageRepository.save(new Image(null, announcement13, "http://example.com/image13.jpg"));
        this.imageRepository.save(new Image(null, announcement14, "http://example.com/image14.jpg"));
        this.imageRepository.save(new Image(null, announcement15, "http://example.com/image15.jpg"));
        this.imageRepository.save(new Image(null, announcement16, "http://example.com/image16.jpg"));
    }
}
