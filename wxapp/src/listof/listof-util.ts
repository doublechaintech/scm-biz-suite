import { isNotEmpty } from '@/nice-router/nice-router-util';
import { EleObject, ImageLike, ImageListLike } from '@/nice-router/nice-router-types';

const defaultImage = '';

function getImageUrl(
  item: {
    coverImage?: string;
    heroImage?: string;
  } & ImageLike &
    ImageListLike
): string {
  const { imageList = [], imageUrl, coverImage, heroImage } = item || {};
  if (coverImage) {
    return coverImage;
  }
  if (heroImage) {
    return heroImage;
  }
  if (imageUrl) {
    return imageUrl;
  }
  if (imageList.length > 0) {
    return imageList[0].imageUrl || '';
  }
  return defaultImage;
}

function getImageList(item: ImageLike & ImageListLike & EleObject = {}): ImageLike[] {
  const { imageList = [], imageUrl } = item;
  if (isNotEmpty(imageList)) {
    return imageList;
  }
  if (isNotEmpty(imageUrl)) {
    return [{ imageUrl }];
  }

  return [];
}

function getItemWidth(displayMode) {
  if (['product', 'v-card'].indexOf(displayMode) > -1) {
    return '49%';
  }
}

function isSelfHoldClickTemplate(displayMode: string, item: Record<string, any> = {}): boolean {
  if ('card' === displayMode) {
    // @ts-ignore
    return isNotEmpty(item.documentUrl) || isNotEmpty(item.actionList);
  }
  return 'navigation-line' === displayMode;
}

const ListofUtil = {
  getItemWidth,
  getImageList,
  getImageUrl,
  isSelfHoldClickTemplate,
};

export default ListofUtil;
