<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-button @click="navigateBack">
                    <ion-icon slot="icon-only" :icon="arrowBackOutline"></ion-icon>
                </ion-button>
                <IonTitle>Check Room Availability</IonTitle>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <form @submit.prevent="checkAvailability">
                <IonItem>
                    <IonLabel position="floating">Arrival Date</IonLabel>
                    <IonInput type="date" v-model="arrivalDate" required></IonInput>
                </IonItem>
                <IonItem>
                    <IonLabel position="floating">Departure Date</IonLabel>
                    <IonInput type="date" v-model="departureDate" required></IonInput>
                </IonItem>
                <IonItem>
                    <IonLabel position="floating">Number of Persons</IonLabel>
                    <IonInput type="number" v-model="numberOfPersons" min="1" required></IonInput>
                </IonItem>
                <div class="availability-button-container">
                    <ion-button type="submit" color="mygreen">Check Availability</ion-button>
                </div>
            </form>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon, IonItem, IonLabel, IonInput } from '@ionic/vue';
import { arrowBackOutline } from 'ionicons/icons';
import { defineComponent } from 'vue';
import { useRoute } from 'vue-router';

export default defineComponent({
    name: 'RoomAvailabilityCheckPage',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonButton,
        IonIcon,
        IonItem,
        IonLabel,
        IonInput,
    },
    data() {
        return {
            arrivalDate: '',
            departureDate: '',
            numberOfPersons: 1,
            roomId: null as number | null,
        };
    },
    created() {
        const route = useRoute();
        this.roomId = Number(route.params.roomId);
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
        checkAvailability() {
            alert(`Checking availability for Room ID: ${this.roomId}, Arrival Date: ${this.arrivalDate}, Departure Date: ${this.departureDate}, Number of Persons: ${this.numberOfPersons}`);
        },
    },
});
</script>

<style scoped>
.availability-button-container {
    margin-top: 20px;
    display: flex;
    justify-content: center;
}
</style>
