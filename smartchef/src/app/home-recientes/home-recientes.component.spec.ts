import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { HomeRecientesComponent } from './home-recientes.component';

describe('HomeRecientesComponent', () => {
  let component: HomeRecientesComponent;
  let fixture: ComponentFixture<HomeRecientesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [HomeRecientesComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(HomeRecientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
