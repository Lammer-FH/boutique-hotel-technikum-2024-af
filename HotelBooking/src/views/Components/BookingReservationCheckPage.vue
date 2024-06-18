<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-button @click="navigateBack">
                    <ion-icon slot="icon-only" :icon="arrowBackOutline"></ion-icon>
                </ion-button>
                <IonTitle slot="end">Reservation Check</IonTitle>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <div class="form-container">
                <h1 class="page-title">Check Reservation data?</h1>
                <ReservationForm />
            </div>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon } from '@ionic/vue';
import { arrowBackOutline } from 'ionicons/icons';
import ReservationForm from '../Models/ReservationFormModel.vue';

export default {
    name: 'BookingReservationCheckPage',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonButton,
        IonIcon,
        ReservationForm,
    },
    setup() {
        return {
            arrowBackOutline,
        };
    },
    methods: {
        navigateBack() {
            this.$router.back();
        },
    },
};
</script>

<style scoped>
.page-title {
    text-align: center;
    font-size: 2em;
    margin-bottom: 20px;
}

.form-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100%;
}
</style>
