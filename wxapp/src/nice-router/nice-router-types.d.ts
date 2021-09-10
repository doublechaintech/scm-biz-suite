import { EleButtonProps } from '@/components/elements/ele-button';

export interface ImageLike {
  imageUrl?: string;
}

export interface ImageListLike {
  imageList?: ImageLike[];
}

export interface IconLike {
  icon?: string;
}

export interface VideoLike {
  videoUrl?: string;
}

export interface ActionLike {
  code?: string;
  linkToUrl?: string;
  onClick?: Function;
  onChange?: Function;
  extraData?: any;
  disabled?: boolean;
  statInPage?: boolean;
}

export interface ModeClass {
  mode?: string | string[];
  className?: string;
}

export interface EleObject {
  id?: string;
  title?: string;
  brief?: string;
}

// title就是name  ,id就是值，就是value
export interface CandidateValue extends EleObject {
  selected?: boolean;
}

export interface TitleValue {
  title?: any;
  value?: any;
}

export interface ActionListLike {
  actionList: EleButtonProps[];
}
