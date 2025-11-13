import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PaginaEditaPerfilComponent } from './pagina-edita-perfil.component';

describe('PaginaEditaPerfilComponent', () => {
  let component: PaginaEditaPerfilComponent;
  let fixture: ComponentFixture<PaginaEditaPerfilComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [PaginaEditaPerfilComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PaginaEditaPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
