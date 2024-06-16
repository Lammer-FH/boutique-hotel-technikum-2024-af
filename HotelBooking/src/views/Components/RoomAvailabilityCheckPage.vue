<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-button @click="navigateBack">
                    <ion-icon slot="icon-only" :icon="arrowBackOutline"></ion-icon>
                </ion-button>
                <IonTitle slot="end">When would you like to visit us?</IonTitle>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <div class="form-container">
                <h1 class="page-title">Check Room Availability</h1>
                <form @submit.prevent="checkAvailability" class="availability-form">
                    <IonItem class="form-item">
                        <IonLabel position="floating">Arrival Date</IonLabel>
                        <IonInput type="date" v-model="arrivalDate" required></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Departure Date</IonLabel>
                        <IonInput type="date" v-model="departureDate" required></IonInput>
                    </IonItem>
                    <div class="availability-button-container">
                        <ion-button type="submit" color="mygreen" class="availability-button">Check
                            Availability</ion-button>
                    </div>
                </form>
            </div>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon, IonItem, IonLabel, IonInput, alertController } from '@ionic/vue';
import { arrowBackOutline } from 'ionicons/icons';
import { defineComponent } from 'vue';
import { useRoute } from 'vue-router';
import { useBookingStore } from '../Stores/BookingStore'

// interface BookingTime {
//     id: number;
//     startdate: string;
//     enddate: string;
// }

// const errorAlert = async () => {
//     const alert = await alertController.create({
//       header: 'A Short Title Is Best',
//       subHeader: 'A Sub Header Is Optional',
//       message: 'A message should be a short, complete sentence.',
//       buttons: ['Action'],
//     });

//     await alert.present();
//   };

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
        async checkAvailability() {
            if(!this.checkDateOrder())
            {
                return;
            }

            const bookingStore = useBookingStore();
            await bookingStore.checkAvailability(this.roomId as number, this.arrivalDate, this.departureDate);

            if(bookingStore.response === 200)
            {
                if(bookingStore.roomAvailability?.roomIsAvailable === true)
                {
                    alert("Success");
                    //route
                }
                else
                {
                    this.errorAlert("Room not available", "The room is already booked until "+bookingStore.roomAvailability?.nextTimeAvailable+" . Please adjust your timeframe.");
                }
            }
            else
            {
                this.errorAlert("Unknown error", "The request could not be completed. Please try again later. If the error persists, please contact us under info@luxorahotel.com.");
            }
        },
        async errorAlert(header: string, message: string) {
            const alert = await alertController.create({
            header: header,
            message: message,
            buttons: ['OK'],
            });

            await alert.present();
        },
        checkDateOrder() {
            if(new Date(this.arrivalDate).getTime() > new Date(this.departureDate).getTime())
            {
                this.errorAlert("Date error", "The deperature can not occur before the arrival. Please correct your input.");
                return false;
            }
            else if(new Date(this.arrivalDate).getTime() == new Date(this.departureDate).getTime())
            {
                this.errorAlert("Date error", "The deperature can not be on the same day as the arrival. Please correct your input.");
                return false;
            }
            else
            {
                return true
            }
        },
    },
});
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

.availability-form {
    width: 100%;
    max-width: 500px;
    padding: 20px;
    background: var(--ion-color-light);
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.form-item {
    --highlight-height: 2px;
    --highlight-color-focused: var(--ion-color-primary);
    --inner-padding-top: 10px;
    --padding-bottom: 10px;
}

.form-item ion-label {
    margin-bottom: 10px;
}

.availability-button-container {
    display: flex;
    justify-content: center;
}

.availability-button {
    width: 100%;
    max-width: 20em;
    font-size: 1.2em;
}

ion-input {
    --padding-start: 8px;
    font-size: 1.2em;
}

ion-label {
    --color: var(--ion-color-primary);
    font-size: 1.2em;
}

ion-button {
    --background: var(--ion-color-primary);
    --background-hover: var(--ion-color-primary-shade);
    --background-activated: var(--ion-color-primary-tint);
    --border-radius: 8px;
    --box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

@media (max-width: 767px) {
    .availability-form {
        width: 100%;
        max-width: 100%;
        padding: 10px;
    }

    .availability-button {
        font-size: 1em;
    }
}
</style>
