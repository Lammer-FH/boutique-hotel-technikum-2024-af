<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-title slot="end">Imprint</ion-title>
            </IonToolbar>
        </IonHeader>

        <IonContent class="ion-padding">
            <h2>Legal Information</h2>
            <p>
                Luxora Hotel <br>
                123 Main Street <br>
                City, State, Zip Code <br>
                Country
            </p>
            <p>
                Contact <br>
                Phone: +123-456-7890 <br>
                Email: info@luxorahotel.com <br>
            </p>
            <p>
                Represented by
                <br>
                John Smith
                General Manager
                <br>
                VAT Identification Number
                <br>
                VAT ID: XXXXXXXX
            </p>
            <h3>Disclaimer</h3>
            <p>The information contained on this website is for general information purposes only. While we strive to
                keep the information up to date and correct, we make no representations or warranties of any kind,
                express or implied, about the completeness, accuracy, reliability, suitability, or availability with
                respect to the website or the information, products, services, or related graphics contained on the
                website for any purpose. Any reliance you place on such information is therefore strictly at your own
                risk.
            </p>
            <p> In no event will we be liable for any loss or damage including without limitation, indirect or
                consequential loss or damage, or any loss or damage whatsoever arising from loss of data or profits
                arising out of, or in connection with, the use of this website.</p>
            <p> Through this website, you are able to link to other websites that are not under the control of Luxora
                Hotel. We have no control over the nature, content, and availability of those sites. The inclusion of
                any links does</p>
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
    name: 'ImprintPage',
    components: { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon },
    setup() {
        return {
            arrowBack
        };
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