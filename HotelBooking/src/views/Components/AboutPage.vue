<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-title slot="end">About Us</ion-title>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <h2>Welcome to Our Hotel</h2>
            <p>
                Nestled in the heart of the city, Luxora Hotel offers a sanctuary of luxury and sophistication. Our
                hotel boasts a rich history, having been established over a century ago, and has since been a symbol of
                elegance and hospitality. We pride ourselves on delivering exceptional service and an unparalleled guest
                experience.
            </p>
            <h3>Our Story</h3>
            <p>
                Luxora Hotel began its journey in 1920 as a small boutique hotel catering to discerning travelers. Over
                the years, we have grown and evolved, maintaining our heritage while embracing modernity. Our commitment
                to preserving the legacy of our historic building, combined with contemporary upgrades, makes Luxora
                Hotel a unique blend of old-world charm and modern luxury.
            </p>
            <h3>Amenities</h3>
            <p>We offer a range of world-class amenities designed to make your stay as comfortable and enjoyable as
                possible. Our facilities include a state-of-the-art fitness center, a serene spa, gourmet dining
                options, and a rooftop pool with breathtaking views of the city skyline. Whether you're here for
                business or leisure, Luxora Hotel provides everything you need for a memorable stay.</p>
            <h3>Our Commitment to Sustainability </h3>
            <p>At Luxora Hotel, we are dedicated to sustainable practices that minimize our environmental impact. We
                have implemented energy-efficient systems, water conservation measures, and waste reduction programs to
                ensure that our operations are as eco-friendly as possible. Our commitment to sustainability extends to
                our community involvement and support for local businesses.</p>
            <h3>Exceptional Service </h3>
            <p>Our team of dedicated professionals is committed to providing you with exceptional service from the
                moment you arrive until your departure. We strive to exceed your expectations by anticipating your needs
                and offering personalized attention. Your comfort and satisfaction are our top priorities.</p>
            <h3>Join Us </h3>
            <p>We invite you to experience the elegance and charm of Luxora Hotel. Whether you're staying with us for a
                night or an extended visit, we promise to make your stay unforgettable. Come and discover why Luxora
                Hotel is the perfect destination for luxury, comfort, and exceptional service.</p>
            <ion-button class="return-button" @click="$router.push('/')">
                <ion-icon slot="icon-only" :icon="arrowBack"></ion-icon>
            </ion-button>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon } from '@ionic/vue';
import { arrowBack } from 'ionicons/icons';

export default {
    name: 'AboutPage',
    components: { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon },
    setup() {
        return {
            arrowBack
        }
    }
};
</script>

<style scoped>
p {
    text-align: justify;
    padding-left: 40px;
    padding-right: 40px;
    font-size: 1.3em;
}

.return-button {
    position: fixed;
    bottom: 20px;
    right: 20px;
}
</style>