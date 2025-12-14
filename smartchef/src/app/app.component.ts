import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import {personOutline, checkmarkDoneCircleOutline,returnUpBackOutline,
  checkmarkOutline,personAddOutline,heartOutline,
  timeOutline,leafOutline,homeOutline,searchOutline,addCircleOutline,closeOutline,alarmOutline,createOutline,
  funnelOutline, peopleOutline,cubeOutline,calendarOutline,hourglassOutline,eyeOutline,heartCircleOutline,bookOutline,cartOutline,
  folderOpenOutline,arrowBackOutline,fastFoodOutline,trashOutline,addOutline,optionsOutline} from "ionicons/icons";
import {addIcons} from "ionicons";


@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [IonApp, IonRouterOutlet],
})

export class AppComponent {
  constructor() {
    addIcons({
      personOutline,
      checkmarkDoneCircleOutline,
      returnUpBackOutline,
      checkmarkOutline,
      personAddOutline,
      heartOutline,
      timeOutline,
      leafOutline,
      homeOutline,
      searchOutline,
      addCircleOutline,
      closeOutline,
      alarmOutline,
      createOutline,
      funnelOutline,
      peopleOutline,
      cubeOutline,
      calendarOutline,
      hourglassOutline,
      eyeOutline,
      heartCircleOutline,
      bookOutline,
      cartOutline,
      folderOpenOutline,
      arrowBackOutline,
      fastFoodOutline,
      trashOutline,
      addOutline,
      optionsOutline
    })
  }
}
