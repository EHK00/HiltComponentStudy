## Hilt component vs scope

Hilt Component lifetime, scope binding과 관련하여 인스턴스 테스트를 진행합니다.

### 테스트

[SingletonScopeTestFragment](https://github.com/)


- installIn(FragmentComponent) vs @FragmentScope annotation provide function
logcat1
@FragmentScope 여부에 따라서 동일 fragment에 대하여 새롭게 bind하거나, 기존 instance를 활용합니다.

- class define with / without @FragmentScoped annotation

[ByConstructorInjectModelImpl](https://github.com/)
@FragmentScoped 주석처리 여부에 따른 차이

@FragmentScoped 주석
-logcat2
@FragmentScoped annotated provider -> 동일 컴포넌트 범위에 대해 동일 인스턴스를 참조합니다
그외에는 새로 할당합니다.


-logcat3
@FragmentScoped
동일 컴포넌트 범위에 대해 동일 인스턴스를 참조합니다







## 결론
component는 바인딩되는 모듈의 수명 주기 설정 범위를 제한하며, scope binding을 통해 인스턴스 공유 여부를 설정합니다.

기본적으로 대거는 매 binding 요청마다 새 인스턴스를 생성합니다.
scope annotation을 통해 해당 바인딩에 대한 모든 요청은 동일한 인스턴스를 공유합니다.

<표 참고>





[참고 사이트 : https://dagger.dev/hilt/components](https://dagger.dev/hilt/components)

