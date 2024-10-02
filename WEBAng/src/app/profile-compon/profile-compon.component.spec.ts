import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileComponComponent } from './profile-compon.component';

describe('ProfileComponComponent', () => {
  let component: ProfileComponComponent;
  let fixture: ComponentFixture<ProfileComponComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProfileComponComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfileComponComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
