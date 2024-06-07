<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-title slot="end">Welcome Traveler</ion-title>
            </IonToolbar>
        </IonHeader>
        <IonContent>
            <div class="hotel-info">
                <h1>Grand Palace Hotel</h1>
                <p>
                    Welcome to the Grand Palace Hotel, where elegance meets comfort in the heart of the city. Our
                    luxurious rooms are designed with sophisticated decor and premium amenities to ensure a memorable
                    stay. Indulge in gourmet dining at our award-winning restaurant, unwind in our state-of-the-art spa,
                    and enjoy stunning city views from our rooftop terrace. At Grand Palace Hotel, exceptional service
                    and unparalleled hospitality await you.
                </p>
                <div class="hotel-images">
                    <div class="image-wrapper">
                        <ion-thumbnail>
                            <img src="/WelcomePageImages/hotel1.jpg" alt="Hotel Image 1">
                        </ion-thumbnail>
                        <div class="description">Front Side</div>
                    </div>
                    <div class="image-wrapper">
                        <ion-thumbnail>
                            <img src="/WelcomePageImages/hotel2.jpg" alt="Hotel Image 2">
                        </ion-thumbnail>
                        <div class="description">Pool</div>
                    </div>
                    <div class="image-wrapper">
                        <ion-thumbnail>
                            <img src="/WelcomePageImages/hotel3.jpg" alt="Hotel Image 3">
                        </ion-thumbnail>
                        <div class="description">Interior</div>
                    </div>
                </div>
                <ion-button class="check-rooms-button" @click="$router.push('/room-overview')">Check Rooms</ion-button>
            </div>
        </IonContent>
        <FooterPage></FooterPage>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonTitle, IonContent, IonToolbar, IonThumbnail, IonButton } from '@ionic/vue';
import FooterPage from '../Models/FooterModel.vue'

export default {
    name: 'HotelInfoPage',
    components: {
        IonPage,
        IonHeader,
        IonTitle,
        IonContent,
        IonToolbar,
        IonThumbnail,
        IonButton,
        FooterPage
    }
};
</script>

<style scoped>
.hotel-info {
    padding: 16px;
    text-align: center;
}

.hotel-info p {
    padding-left: 24px;
    padding-right: 24px;
    font-size: 1.3em;
}

.hotel-images {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 16px;
}

.image-wrapper {
    text-align: center;
    margin-bottom: 16px;
}

.description {
    margin-top: 8px;
    font-size: 0.9em;
    font-style: italic;
}

ion-thumbnail {
    width: 200px;
    height: 200px;
}

ion-thumbnail img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.check-rooms-button {
    margin-top: 16px;
}

@media (min-width: 600px) {
    .hotel-images {
        flex-direction: row;
        justify-content: space-around;
    }

    ion-thumbnail {
        width: 300px;
        height: 300px;
    }

    .hotel-info p {
        padding-left: 48px;
        padding-right: 48px;
    }
}
</style>