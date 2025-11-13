import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { FavoritosColeccionesComponent } from './favoritos-colecciones.component';

describe('FavoritosColeccionesComponent', () => {
  let component: FavoritosColeccionesComponent;
  let fixture: ComponentFixture<FavoritosColeccionesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [FavoritosColeccionesComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(FavoritosColeccionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
