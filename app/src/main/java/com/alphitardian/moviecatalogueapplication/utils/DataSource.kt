package com.alphitardian.moviecatalogueapplication.utils

import com.alphitardian.moviecatalogueapplication.model.ShowEntity
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemMovie
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemTvShow

object DataSource {
    fun getMovies(): List<ShowEntity> {
        val movies = ArrayList<ShowEntity>()

        movies.add(
            ShowEntity(
                "m1",
                "A Star Is Born",
                "2018",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75",
                "R.drawable.film_poster_a_start_is_born",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m2",
                "Alita : Battle Angel",
                "2019",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "72",
                "R.drawable.film_poster_alita",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m3",
                "Aquaman",
                "2018",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "69",
                "R.drawable.film_poster_aquaman",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m4",
                "Creed II",
                "2018",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "69",
                "R.drawable.film_poster_creed",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m5",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "69",
                "R.drawable.film_poster_crimes",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m6",
                "Glass",
                "2019",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "67",
                "R.drawable.film_poster_glass",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m7",
                "How to Train Your Dragon: The Hidden World",
                "2019",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "78",
                "R.drawable.film_poster_how_to_train",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m8",
                "Avengers: Infinity War",
                "2018",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "83",
                "R.drawable.film_poster_infinity_war",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m9",
                "Mary Queen of Scots",
                "2018",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "66",
                "R.drawable.film_poster_marry_queen",
                true
            )
        )
        movies.add(
            ShowEntity(
                "m10",
                "Master Z: Ip Man Legacy",
                "2018",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "60",
                "R.drawable.film_poster_master_z",
                true
            )
        )

        return movies
    }

    fun getTvShows(): List<ShowEntity> {
        var tvShows = ArrayList<ShowEntity>()

        tvShows.add(
            ShowEntity(
                "tv1",
                "Arrow",
                "2012",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "66",
                "R.drawable.tv_poster_arrow",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv2",
                "Bohemian Rhapsody",
                "2018",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "80",
                "R.drawable.tv_poster_bohemian",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv3",
                "Cold Pursuit",
                "2019",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "57",
                "R.drawable.tv_poster_cold_persuit",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv4",
                "Doom Patrol",
                "2019",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "76",
                "R.drawable.tv_poster_doom_patrol",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv5",
                "Dragon Ball",
                "1986",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "81",
                "R.drawable.tv_poster_dragon_ball",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv6",
                "Fairy Tail",
                "2009",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "78",
                "R.drawable.tv_poster_fairytail",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv7",
                "Family Guy",
                "1999",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "78",
                "R.drawable.tv_poster_family_guy",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv8",
                "The Flash",
                "2014",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "77",
                "R.drawable.tv_poster_flash",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv9",
                "Game of Thrones",
                "2011",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "84",
                "R.drawable.tv_poster_god",
                false
            )
        )
        tvShows.add(
            ShowEntity(
                "tv10",
                "Gotham",
                "2014",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "84",
                "R.drawable.tv_poster_gotham",
                false
            )
        )

        return tvShows
    }

    fun getMoviesRemote(): List<ResultsItemMovie> {
        val movies = ArrayList<ResultsItemMovie>()

        movies.add(
            ResultsItemMovie(
                1,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "R.drawable.film_poster_a_start_is_born",
                "2018",
                75.0,
            )
        )
        movies.add(
            ResultsItemMovie(
                2,
                "Alita : Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "R.drawable.film_poster_alita",
                "2019",
                72.0
            )
        )
        movies.add(
            ResultsItemMovie(
                3,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "R.drawable.film_poster_aquaman",
                "2018",
                69.0
            )
        )
        movies.add(
            ResultsItemMovie(
                4,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "R.drawable.film_poster_creed",
                "2018",
                69.0
            )
        )
        movies.add(
            ResultsItemMovie(
                5,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "R.drawable.film_poster_crimes",
                "2018",
                69.0
            )
        )
        movies.add(
            ResultsItemMovie(
                6,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "R.drawable.film_poster_glass",
                "2019",
                67.0
            )
        )
        movies.add(
            ResultsItemMovie(
                7,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "R.drawable.film_poster_how_to_train",
                "2019",
                78.0
            )
        )
        movies.add(
            ResultsItemMovie(
                8,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "R.drawable.film_poster_infinity_war",
                "2018",
                83.0
            )
        )
        movies.add(
            ResultsItemMovie(
                9,
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "R.drawable.film_poster_marry_queen",
                "2018",
                66.0
            )
        )
        movies.add(
            ResultsItemMovie(
                10,
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "R.drawable.film_poster_master_z",
                "2018",
                60.0
            )
        )

        return movies
    }

    fun getTvShowsRemote(): List<ResultsItemTvShow> {
        var tvShows = ArrayList<ResultsItemTvShow>()

        tvShows.add(
            ResultsItemTvShow(
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "R.drawable.tv_poster_arrow",
                "2012",
                66.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                2,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "R.drawable.tv_poster_bohemian",
                "2018",
                80.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                3,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "R.drawable.tv_poster_cold_persuit",
                "2019",
                57.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                4,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "R.drawable.tv_poster_doom_patrol",
                "2019",
                76.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                5,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "R.drawable.tv_poster_dragon_ball",
                "1986",
                81.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                6,
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "R.drawable.tv_poster_fairytail",
                "2009",
                78.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                7,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "R.drawable.tv_poster_family_guy",
                "1999",
                78.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                8,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "R.drawable.tv_poster_flash",
                "2014",
                77.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                9,
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "R.drawable.tv_poster_god",
                "2011",
                84.0
            )
        )
        tvShows.add(
            ResultsItemTvShow(
                10,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "R.drawable.tv_poster_gotham",
                "2014",
                84.0
            )
        )

        return tvShows
    }
}