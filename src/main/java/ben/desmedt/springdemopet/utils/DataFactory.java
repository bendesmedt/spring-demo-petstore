package ben.desmedt.springdemopet.utils;

import ben.desmedt.springdemopet.models.Category;
import ben.desmedt.springdemopet.models.Tag;
import ben.desmedt.springdemopet.models.Pet;
import ben.desmedt.springdemopet.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class DataFactory {

    public static List<User> getUsers() {
        return Arrays.stream(USER_DATA)
                .map(DataFactory::convertToUser)
                .collect(Collectors.toList());
    }

    public static List<Category> getCategories() {
        return List.of(
                new Category().setName("Guinea Pig"),
                new Category().setName("Cat"),
                new Category().setName("Rabbit"),
                new Category().setName("Snake"),
                new Category().setName("Dog"),
                new Category().setName("Bird"),
                new Category().setName("Hamster"),
                new Category().setName("Rat"),
                new Category().setName("Mouse"),
                new Category().setName("Lizard"),
                new Category().setName("Turtle"),
                new Category().setName("Dove"),
                new Category().setName("Fish"),
                new Category().setName("Squirrel"),
                new Category().setName("Duck"),
                new Category().setName("Chicken"),
                new Category().setName("Pig")
        );
    }

    public static List<Tag> getTags() {
        return List.of(
                new Tag().setName("male"),
                new Tag().setName("female"),
                new Tag().setName("neutered"),
                new Tag().setName("safe with kids"),
                new Tag().setName("safe with other pets"),
                new Tag().setName("trained"),
                new Tag().setName("can be home alone"),
                new Tag().setName("junior"),
                new Tag().setName("adult"),
                new Tag().setName("senior")
        );
    }

    public static List<Pet> getPets(List<Tag> tags, List<Category> categories) {

        List<Pet> pets = new ArrayList<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (String petName : PET_NAMES) {

            pets.add(new Pet()
                    .setName(petName)
                    .setCategory(categories != null ? categories.get(random.nextInt(0, categories.size())): null)
                    .setTags(List.of(
                                    tags.get(Math.round(random.nextFloat())), //GENDER
                                    tags.get(random.nextInt(2, 7)),
                                    tags.get(random.nextInt(7, tags.size())) //AGE
                            )
                    )
                    .setStatus(Pet.Status.values()[random.nextInt(0, Pet.Status.values().length)])
                    .setPhotoUrls(
                            random.ints(3, 0, IMAGES.length)
                                    .mapToObj(i -> IMAGES[i])
                                    .collect(Collectors.toList())
                    )
            );
        }

        return pets;
    }

    private static User convertToUser(String userString) {
        String[] userArray = userString.split("_");
        return new User()
                .setUsername(userArray[0])
                .setFirstName(userArray[1])
                .setLastName(userArray[2])
                .setEmail(userArray[3])
                .setPassword(userArray[4])
                .setPhone(userArray[5])
                .setUserStatus(Integer.parseInt(userArray[6]));
    }


    private static final String[] PET_NAMES = new String[]{ "Charlie", "Max", "Buddy", "Milo", "Archie",
            "Ollie", "Oscar", "Teddy", "Leo", "Alfie", "Bella", "Luna", "Coco", "Ruby", "Molly", "Frankie", "Daisy",
            "Rosie", "Lucy", "Lola", "Poppy", "Misty", "Milly", "Smudge", "Danny", "Ozzy", "Tilly"
    };

    private static final String[] IMAGES = new String[]{ "http://dummyimage.com/152x100.png/cc0000/ffffff",
            "http://dummyimage.com/180x100.png/ff4444/ffffff", "http://dummyimage.com/171x100.png/ff4444/ffffff",
            "http://dummyimage.com/105x100.png/dddddd/000000", "http://dummyimage.com/235x100.png/cc0000/ffffff",
            "http://dummyimage.com/235x100.png/ff4444/ffffff", "http://dummyimage.com/237x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/119x100.png/dddddd/000000", "http://dummyimage.com/106x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/249x100.png/dddddd/000000", "http://dummyimage.com/118x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/247x100.png/cc0000/ffffff", "http://dummyimage.com/121x100.png/cc0000/ffffff",
            "http://dummyimage.com/164x100.png/ff4444/ffffff", "http://dummyimage.com/187x100.png/dddddd/000000",
            "http://dummyimage.com/237x100.png/5fa2dd/ffffff", "http://dummyimage.com/238x100.png/ff4444/ffffff",
            "http://dummyimage.com/187x100.png/cc0000/ffffff", "http://dummyimage.com/229x100.png/ff4444/ffffff",
            "http://dummyimage.com/136x100.png/dddddd/000000", "http://dummyimage.com/192x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/148x100.png/dddddd/000000", "http://dummyimage.com/225x100.png/cc0000/ffffff",
            "http://dummyimage.com/186x100.png/ff4444/ffffff", "http://dummyimage.com/147x100.png/cc0000/ffffff",
            "http://dummyimage.com/218x100.png/ff4444/ffffff", "http://dummyimage.com/141x100.png/cc0000/ffffff",
            "http://dummyimage.com/231x100.png/dddddd/000000", "http://dummyimage.com/117x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/109x100.png/dddddd/000000", "http://dummyimage.com/241x100.png/ff4444/ffffff",
            "http://dummyimage.com/161x100.png/5fa2dd/ffffff", "http://dummyimage.com/218x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/151x100.png/ff4444/ffffff", "http://dummyimage.com/139x100.png/ff4444/ffffff",
            "http://dummyimage.com/227x100.png/ff4444/ffffff", "http://dummyimage.com/248x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/172x100.png/5fa2dd/ffffff", "http://dummyimage.com/226x100.png/ff4444/ffffff",
            "http://dummyimage.com/177x100.png/5fa2dd/ffffff", "http://dummyimage.com/107x100.png/dddddd/000000",
            "http://dummyimage.com/140x100.png/dddddd/000000", "http://dummyimage.com/239x100.png/cc0000/ffffff",
            "http://dummyimage.com/150x100.png/dddddd/000000", "http://dummyimage.com/140x100.png/dddddd/000000",
            "http://dummyimage.com/222x100.png/ff4444/ffffff", "http://dummyimage.com/216x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/141x100.png/cc0000/ffffff", "http://dummyimage.com/226x100.png/dddddd/000000",
            "http://dummyimage.com/164x100.png/dddddd/000000", "http://dummyimage.com/159x100.png/ff4444/ffffff",
            "http://dummyimage.com/203x100.png/dddddd/000000", "http://dummyimage.com/242x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/102x100.png/cc0000/ffffff", "http://dummyimage.com/141x100.png/5fa2dd/ffffff",
            "http://dummyimage.com/105x100.png/ff4444/ffffff", "http://dummyimage.com/213x100.png/cc0000/ffffff",
            "http://dummyimage.com/113x100.png/dddddd/000000", "http://dummyimage.com/129x100.png/dddddd/000000",
            "http://dummyimage.com/242x100.png/cc0000/ffffff", "http://dummyimage.com/182x100.png/cc0000/ffffff",
            "http://dummyimage.com/189x100.png/ff4444/ffffff", "http://dummyimage.com/163x100.png/cc0000/ffffff",
            "http://dummyimage.com/152x100.png/cc0000/ffffff", "http://dummyimage.com/224x100.png/cc0000/ffffff",
            "http://dummyimage.com/145x100.png/dddddd/000000"
    };

    private static final String[] USER_DATA = {
            "amercey1o_Abey_Mercey_amercey1o@chronoengine.com_NFkTfJz_3657314685_80128",
            "ahuggons1p_Axe_Huggons_ahuggons1p@patch.com_DxL0tS_2606887942_8",
            "cwhawell1q_Caleb_Whawell_cwhawell1q@cyberchimps.com_cXBQiHYyn7V0_1056197922_15740",
            "rcolgan1r_Raeann_Colgan_rcolgan1r@elpais.com_m7Qs9Nm_6921204734_1",
            "hpriden1s_Hanny_Priden_hpriden1s@ezinearticles.com_9GJjpGUZJLnL_4273022408_44545",
            "ienden1t_Ira_Enden_ienden1t@dyndns.org_T7bDZCG_2522077243_1985",
            "ematitiaho1u_Everett_Matitiaho_ematitiaho1u@latimes.com_IhHhKm2TfBE8_8223609971_71",
            "hseymark1v_Hill_Seymark_hseymark1v@slashdot.org_FxLnpd2G_9635333435_7839",
            "gkreber1w_Giusto_Kreber_gkreber1w@msn.com_OdcMcE8du0_8838863628_1859",
            "mprichet1x_Millicent_Prichet_mprichet1x@pinterest.com_fj6MtNi_8536371128_1535",
            "bvolkes1y_Barrie_Volkes_bvolkes1y@soundcloud.com_KMdW1Wwvgo_9563575254_77",
            "cconradie1z_Corrina_Conradie_cconradie1z@europa.eu_nuGZggkyk_6405975036_91",
            "speiser20_Stevena_Peiser_speiser20@angelfire.com_DWj3zSxs_1651449293_9",
            "sarniz21_Sloane_Arniz_sarniz21@geocities.com_kJkTGzPIQnsB_8715147771_85826",
            "edelchecolo22_Ethelda_Del Checolo_edelchecolo22@pen.io_8hJOk2hp6G2_1264845226_33548",
            "nklesl23_Nyssa_Klesl_nklesl23@xrea.com_dbO6C3tv42V1_9776068169_5717",
            "ncraufurd24_Noel_Craufurd_ncraufurd24@sogou.com_r3YNKRzkkmqi_1217074378_45019",
            "myesenev25_Meggi_Yesenev_myesenev25@sun.com_Ri4PsWDgV8_7294636275_9",
            "abracchi26_Andres_Bracchi_abracchi26@photobucket.com_WHM9cji_4822536835_1670",
            "gvoyce27_Galvan_Voyce_gvoyce27@eepurl.com_nne2vwXzC_5943581321_7156",
            "adewett28_Ashlie_Dewett_adewett28@pen.io_coLrl549Zo_4539007980_00563",
            "gavery29_Guy_Avery_gavery29@si.edu_x2lU7jL_3168034029_884",
            "dguerreru2a_Dulcea_Guerreru_dguerreru2a@deliciousdays.com_0kllu98C_5876186197_997",
            "ltuckett2b_Livia_Tuckett_ltuckett2b@wix.com_WMqJLJJhlIqT_4213717935_25075",
            "tgawke2c_Tremain_Gawke_tgawke2c@addtoany.com_cVjQ6ZrFGnn_5798804009_3",
            "kschirak2d_Katinka_Schirak_kschirak2d@arizona.edu_tVUq6CC_4899841707_729",
            "ksimester2e_Karalee_Simester_ksimester2e@cocolog-nifty.com_QCHWPbv_7485305616_66113",
            "ndubarry2f_Nappy_Du Barry_ndubarry2f@liveinternet.ru_sf5rYyuj_6746556895_40",
            "pmattin2g_Penelopa_Mattin_pmattin2g@patch.com_pOFRwl9Y_8785607304_68",
            "nperch2h_Nadiya_Perch_nperch2h@princeton.edu_g4MSnJzr1_4826954345_2",
            "msotham2i_Marisa_Sotham_msotham2i@1und1.de_rRpWXuKvh_2905364050_913",
            "dambresin2j_Dominic_Ambresin_dambresin2j@mapy.cz_kGNuOD8KbfkX_4026787964_0823"
    };
}
