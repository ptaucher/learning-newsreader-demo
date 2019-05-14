package net.pt.demo.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.pt.demo.newsapp.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<NewsArticle> newsArticles = new ArrayList<>();
        newsArticles.add(new NewsArticle(
                "Startschuss",
                "9. April 2019",
                "Hallo und Willkommen in meinem Blogexperiment!\n" +
                        "\n" +
                        "Worum es geht? \n" +
                        "\n" +
                        "Ich habe mir für heuer ein sportliches Projekt vorgenommen – nämlich im Sommer mit dem (Renn)rad von Paris nach Madrid zu fahren, auf der geplanten Strecke macht das ca. 1500 Kilometer, wofür laut Plan 9 Tage Zeit sind.\n" +
                        "\n" +
                        "Wie komme ich dazu?\n" +
                        "\n" +
                        "Nun, an sich habe ich den (Ausdauer)sport schon vor einigen Jahren für mich entdeckt, seit ungefähr 2013 laufe ich oft und regelmäßig, in Spitzenjahren durchaus 3-4x pro Woche und auf diversen Laufveranstaltungen in Österreich, meistens Halbmarathons, ein einziges Mal (erfolgreich deutlich unter 4 Stunden) eine Volldistanz in Berlin und den Wings For Life – hobbymäßig, aber ambitioniert.",
                "https://longroadtomadrid.home.blog/2019/04/10/startschuss/",
                "https://longroadtomadridhome.files.wordpress.com/2019/04/aabb3-route.jpg?w=300"));
        newsArticles.add(new NewsArticle(
                "Das Training - Teil 1",
                "10. April 2019",
                "Nun – nachdem die Anmeldung zu unserem Charity-Ride relativ einfach war (siehe erster Post), hab ich oft die Frage gestellt bekommen, ob ich angesichts der Eckdaten der Tour nicht ein wenig verrückt wäre und wie ich mich darauf vorbereite\n" +
                        "\n" +
                        "1500 Kilometer (ungefähr die Hälfte der Tour de France)\n" +
                        "9 Tage\n" +
                        "12.000 Höhenmeter (also ca. 15 Mal von Graz auf den Schöckl hoch)\n" +
                        "170 Kilometer pro Tag\n" +
                        "Ja, ich gebe zu, mein größter Zweifel bei dem Vorhaben war trotz meiner sportlichen „Vorbildung“ die Länge der Tour. Ich bin im vergangenen Jahr zwar auch brav gefahren, meine Jahresfahrleistung lag aber nur etwas über der Gesamtlänge der Tour. \uD83D\uDE01",
                "https://longroadtomadrid.home.blog/2019/04/10/das-training-teil-i/",
                "https://longroadtomadridhome.files.wordpress.com/2019/04/img_20190220_174519700.jpg?w=272&h=362"));
        newsArticles.add(new NewsArticle(
                "Das Training - Teil 2",
                "13. April 2019",
                "Mir war schnell klar war, dass ich keinen strikten Trainingsplan absolvieren werde, was natürlich nicht bedeuten soll, die Geschichte auf die leichte Schulter zu nehmen. Da ich aber schon ein bisschen Erfahrung mit „Aufbautraining“ habe, versuche ich, es nach Gefühl und orientiere mich nur lose an Plänen, dazu nun mehr…\n" +
                        "\n" +
                        "Das Ziel\n" +
                        "Mein erster Ansatz, wenn ich für einen Lauf oder etwas Besonderes trainiere ist immer ein gewisses Ziel, also eine Gesamtdistanz und/oder Anzahl der Trainings die ich bis zum Start absolvieren möchte. Da ich seit einigen Jahren regelmäßig Sport mache, „tracke“ ich das natürlich auch via GPS (in meinem Fall auf der Garmin-Plattform), wodurch man natürlich einfach Buch führen kann, wie oft/weit man unterwegs ist – und auch schön sieht, ob man schneller/langsamer als beim letzten Mal war.",
                "https://longroadtomadrid.home.blog/2019/04/13/das-training-teil-ii/",
                "https://longroadtomadridhome.files.wordpress.com/2019/04/image-2.png"));
        newsArticles.add(new NewsArticle(
                "Rennrad im Strassenverkehr",
                "3. Mai 2019",
                "Nun, wenn ich mit Arbeitskollegen, Freunden und Bekannten über meine Trainingstouren rede, werd‘ ich manchmal auch gefragt, ob es nicht „gefährlich“ ist, zur nicht zwingend besten Zeit – wochentags, im Berufsverkehr, auf Hauptverkehrsverbindungen – unterwegs zu sein. Selten geht’s darum um die „fahrtechnischen“ Aspekte, z.B. dass man bergab schon mal 70 km/h erreichen kann und Kurven fahren gelernt werden will – mit der Physik muss man sich auch als Hobbysportler auseinandersetzen. Eher gehts darum, dass man aufgrund der Natur des Sports und der mäßigen Eignung von Radwegen verdammt ist, sich in den Straßenverkehr zu mischen – und eben nicht immer die unbefahrene Dortstraße aussuchen kann.",
                "https://longroadtomadrid.home.blog/2019/05/03/rennrad-im-strasenverkehr/",
                "https://longroadtomadridhome.files.wordpress.com/2019/05/roadrage-720x380.png"));
        NewsStore.setNewsArticles(newsArticles);

        newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticles());
        newsRecyclerView.setAdapter(homeNewsAdapter);
    }
}
