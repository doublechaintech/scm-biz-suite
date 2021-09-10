import { NavigationMethodType } from '@/nice-router/navigation-service';

export type BackendServiceSendProps = {
  method?: 'get' | 'post' | 'put';
  uri: string;
  params?: Record<string, any>;
  headers?: Record<string, any>;
  loading: any;
  asForm?: boolean;
  cache?: number;
};

export type HttpResponse = {
  xClass: string;
  xNavigationMethod: NavigationMethodType;
  data: any;
  message: string;
  status: string;
  headers: Record<string, any>;
  success: boolean;
};
