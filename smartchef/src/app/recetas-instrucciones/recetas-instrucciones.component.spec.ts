import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { RecetasInstruccionesComponent } from './recetas-instrucciones.component';

describe('RecetasInstruccionesComponent', () => {
  let component: RecetasInstruccionesComponent;
  let fixture: ComponentFixture<RecetasInstruccionesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [RecetasInstruccionesComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(RecetasInstruccionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
