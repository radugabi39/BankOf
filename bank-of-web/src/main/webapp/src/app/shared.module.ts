import { NgModule } from '@angular/core';
import { PolymerElement } from '@vaadin/angular2-polymer';
@NgModule({
  declarations: [
    PolymerElement('paper-input'),    
    PolymerElement('paper-card'),
    PolymerElement('paper-button'),
    PolymerElement('paper-tabs'),
    PolymerElement('paper-material'),
    PolymerElement('paper-toolbar'),
    PolymerElement('paper-tab'),
    PolymerElement('iron-pages')
  ],  exports: [
    PolymerElement('paper-input'),    
    PolymerElement('paper-card'),
    PolymerElement('paper-button'),
    PolymerElement('paper-tabs'),
    PolymerElement('paper-material'),
    PolymerElement('paper-toolbar'),
    PolymerElement('paper-tab'),
    PolymerElement('iron-pages')
  ]
})
export class SharedModule {}