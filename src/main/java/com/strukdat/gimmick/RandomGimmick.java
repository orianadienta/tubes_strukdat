package com.strukdat.gimmick;

import java.util.Random;

public class RandomGimmick implements GimmickInterface {
    @Override
    public String runGimmick() {
        Random random = new Random();
        String[] facts = {
                "Sebuah awan bisa memiliki berat sekitar satu juta ton. \nJenis awan kumulus diperkirakan memiliki kepadatan sekitar 0,5 gram per meter kubik. Dengan demikian, awan 1 km per kubik berarti sama dengan 1 miliar meter kubik. \nJika dihitung, 1.000.000.000 x 0,5 = 500.000.000 gram tetesan air di awan.  Berarti, berat awan sekitar 500.000 kg atau sekitar 551 ton. Namun, awan yang berat tersebut bisa tetap mengambang \nkarena udara di bawahnya lebih berat dari kepadatan awan.",
                "Saudara kembar identik tidak memiliki sidik jari yang sama. \nHal ini karena faktor lingkungan selama perkembangan di dalam rahim (panjang tali pusat, posisi di dalam rahim, dan kecepatan pertumbuhan jari) berdampak pada sidik jari.",
                "Mike, sekor ayam yang bisa bertahan hidup selama 18 bulan tanpa kepala. \nHal ini karena vena jugularis dan sebagian besar batang otaknya masih utuh, memastikan fungsi otak tetap cukup untuk bertahan hidup. Umumnya, ayam tanpa kepala akan mati dalam hitungan menit.",
                "Takut pada kata-kata yang panjang disebut Hippopotomonstrosesquippedaliophobia. \nKata ini sebenarnyna terdiri dari beberapa suku kata, yaitu \"hippopotamus\", \"monstrous\", \"sesquipedalian\", dan \"-phobia\". Beberapa gejala yang mungkin dialami oleh penderita \nHippopotomonstrosesquippedaliophobia, di antaranya:\n1. Rasa cemas atau panik saat melihat atau mendengar kata panjang. \n2. Detak jantung meningkat, kesulitan bernapas, atau berkeringat. \n3. Merasa ingin menghindar dari situasi di mana ada kata-kata yang sulit atau panjang ",
                "Menara Eiffel bisa bertambah tinggi 15 cm saat musim panas. \nSaat musim panas, panas matahari yang lebih kuat dan lama menyentuh Menara Eiffel menyebabkan bahan metalnya memuai. Fenomena ini disebut ekspansi termal, yaitu saat material dipanaskan, \npartikel-partikelnya akan bergerak berjauhan dan menyebabkan pertambahan volume. Namun, perubahan tinggi Menara Eiffel ini bersifat alami dan sangat kecil, sehingga tidak berdampak pada \nkekokohan struktur menara dan tidak dapat diamati dengan mata telanjang.",
                "Gurita sebenarnya memiliki tiga organ hati. \nGurita memiliki tiga hati: Satu hati utama atau jantung sistematik. Dua hati kecil yang terletak di dekat insang. Ketiga hati gurita berfungsi sebagai sistem peredaran darah. Darah yang mengalir \ndi dalam hati gurita berwarna biru karena mengandung protein yang kaya akan tembaga, yaitu hemocyanin. ",
                "Hanya nyamuk betina yang menggigit manusia. \nHal ini karena nyamuk betina menggigit manusia untuk mendapatkan darah yang dibutuhkan untuk memproduksi telur. Sementara, nyamuk jantan mengisap nektar dan getah tumbuhan untuk \nkebutuhan hidupnya.",
                "San Marino, negara yang dihuni lebih banyak mobil daripada manusia.\nSan Marino adalah negara kecil yang berbatasan langsung dengan Italia. Luas wilayah San Marino hanya 61 kilometer persegi, yang 10 kali lebih kecil dari Chicago. Perbandingan jumlah mobil dan \npenduduk di San Marino adalah 1.139 mobil per 1.000 orang. Bahkan, sebagian warga San Marino memiliki lebih dari satu mobil.",
                "Perang tersingkat di dunia dengan durasi 38 menit.\nPerang ini bernama Perang Zanzibar merupakan perang yang terjadi antara Inggris Raya dan Kesultanan Zanzibar pada tanggal 27 Agustus 1896. Konflik ini dipicu oleh kematian Sultan Hamad \nbin Thuwaini yang pro-Inggris dan pengangkatan Sultan Khalid bin Barghash tanpa persetujuan Inggris. Inggris pun mengirim ultimatum kepada Khalid agar menyerah dan meninggalkan istana. \nNamun, Khalid menolak dengan mengumpulkan pasukannya dan mengurung diri di dalam istana. Inggris kemudian menyerang istana dengan kapal-kapal perang dan pasukan daratnya, \nmenghancurkan pertahanan Khalid dalam waktu singkat.",
                "Ada lebih banyak jumlah bintang di alam semesta daripada jumlah butir pasir di dunia. \nTerdapat sekitar 10 sextillion bintang di alam semesta dan 4 sextillion butir pasir di muka Bumi. Jika ditulis dalam angka: jumlah bintang di jagat raya 10.000.000.000.000.000.000.000 sementara jumlah \nbutir pasir 4.000.000.000.000.000.000.000."
        };

        return facts[random.nextInt(facts.length)];
    }
}
