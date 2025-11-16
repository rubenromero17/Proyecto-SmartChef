import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { TarjetaChefComponent } from './tarjeta-chef.component';

describe('TarjetaChefComponent', () => {
  let component: TarjetaChefComponent;
  let fixture: ComponentFixture<TarjetaChefComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [TarjetaChefComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(TarjetaChefComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
