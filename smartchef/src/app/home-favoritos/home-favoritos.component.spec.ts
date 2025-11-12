import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { HomeFavoritosComponent } from './home-favoritos.component';

describe('HomeFavoritosComponent', () => {
  let component: HomeFavoritosComponent;
  let fixture: ComponentFixture<HomeFavoritosComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [HomeFavoritosComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(HomeFavoritosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
